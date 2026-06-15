/* ================================================
   CYBERSHIELD — Interactive JavaScript
   Pure HTML/CSS/JS — No frameworks
   ================================================ */

'use strict';

/* ---- Utility ---- */
const $ = (sel, ctx = document) => ctx.querySelector(sel);
const $$ = (sel, ctx = document) => [...ctx.querySelectorAll(sel)];

/* ================================================
   1. NAV — Scroll state & hamburger toggle
   ================================================ */
(function initNav() {
  const nav          = $('#main-nav');
  const hamburger    = $('#hamburger-btn');
  const menu         = $('#nav-menu');
  const navLinks     = $$('.nav__link, .nav__cta', menu);

  /* Scroll class */
  const onScroll = () => {
    nav.classList.toggle('scrolled', window.scrollY > 20);
  };
  window.addEventListener('scroll', onScroll, { passive: true });
  onScroll();

  /* Hamburger */
  function toggleMenu(open) {
    const isOpen = open ?? !menu.classList.contains('open');
    menu.classList.toggle('open', isOpen);
    hamburger.setAttribute('aria-expanded', String(isOpen));
    document.body.style.overflow = isOpen ? 'hidden' : '';
  }

  hamburger.addEventListener('click', () => toggleMenu());

  /* Close on link click */
  navLinks.forEach(link => {
    link.addEventListener('click', () => toggleMenu(false));
  });

  /* Close on Escape */
  document.addEventListener('keydown', e => {
    if (e.key === 'Escape' && menu.classList.contains('open')) toggleMenu(false);
  });

  /* Close on backdrop click (outside menu) */
  document.addEventListener('click', e => {
    if (menu.classList.contains('open') && !menu.contains(e.target) && !hamburger.contains(e.target)) {
      toggleMenu(false);
    }
  });
})();


/* ================================================
   2. SCROLL REVEAL — Intersection Observer
   ================================================ */
(function initReveal() {
  const items = $$('.reveal');
  if (!items.length) return;

  const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('in-view');
        observer.unobserve(entry.target);
      }
    });
  }, { threshold: 0.12, rootMargin: '0px 0px -40px 0px' });

  items.forEach((el, i) => {
    /* Stagger siblings inside grids */
    el.style.transitionDelay = `${(i % 6) * 0.07}s`;
    observer.observe(el);
  });
})();


/* ================================================
   3. 3D CARD EFFECT — Mouse Tilt
   ================================================ */
(function initCard3D() {
  const wrap  = $('.hero__card-wrap');
  const card  = $('#card-3d');
  const inner = card?.querySelector('.card-3d__inner');
  const glow  = card?.querySelector('.card-3d__glow');
  if (!wrap || !card || !inner) return;

  const MAX_ROT  = 15;   /* degrees */
  const MAX_LIFT = 10;   /* px */

  function applyTilt(cx, cy, rect) {
    /* Normalize -1 … +1 */
    const nx = (cx - rect.left - rect.width  / 2) / (rect.width  / 2);
    const ny = (cy - rect.top  - rect.height / 2) / (rect.height / 2);

    const rotX  =  -ny * MAX_ROT;
    const rotY  =   nx * MAX_ROT;
    const liftZ =  Math.abs(nx * ny) * MAX_LIFT;

    inner.style.transform = `
      rotateX(${rotX}deg)
      rotateY(${rotY}deg)
      translateZ(${liftZ}px)
    `;

    /* Move glow spot */
    if (glow) {
      const gx = ((cx - rect.left) / rect.width  * 100).toFixed(1);
      const gy = ((cy - rect.top)  / rect.height * 100).toFixed(1);
      glow.style.setProperty('--gx', `${gx}%`);
      glow.style.setProperty('--gy', `${gy}%`);
    }
  }

  function resetTilt() {
    inner.style.transform = 'rotateX(0deg) rotateY(0deg) translateZ(0px)';
    if (glow) {
      glow.style.setProperty('--gx', '50%');
      glow.style.setProperty('--gy', '50%');
    }
  }

  /* Pointer events */
  wrap.addEventListener('mousemove', e => {
    const rect = inner.getBoundingClientRect();
    applyTilt(e.clientX, e.clientY, rect);
  });
  wrap.addEventListener('mouseleave', resetTilt);

  /* Touch events */
  wrap.addEventListener('touchmove', e => {
    const touch = e.touches[0];
    const rect  = inner.getBoundingClientRect();
    applyTilt(touch.clientX, touch.clientY, rect);
  }, { passive: true });
  wrap.addEventListener('touchend', resetTilt);

  /* Gyroscope on mobile (graceful degradation) */
  if (typeof DeviceOrientationEvent !== 'undefined' && window.innerWidth < 900) {
    window.addEventListener('deviceorientation', e => {
      if (e.beta === null) return;
      const nx = (e.gamma ?? 0) / 45;
      const ny = ((e.beta  ?? 0) - 30) / 45;
      const rotX = -ny * (MAX_ROT * 0.5);
      const rotY =  nx * (MAX_ROT * 0.5);
      inner.style.transform = `rotateX(${rotX}deg) rotateY(${rotY}deg)`;
    }, { passive: true });
  }
})();


/* ================================================
   4. PASSWORD STRENGTH CHECKER
   ================================================ */
(function initPasswordStrength() {
  const input    = $('#pw-input');
  const toggle   = $('#pw-toggle');
  const fill     = $('#strength-fill');
  const label    = $('#pw-strength-desc');
  const ruleEls  = {
    length:  $('#rule-length'),
    upper:   $('#rule-upper'),
    lower:   $('#rule-lower'),
    number:  $('#rule-number'),
    special: $('#rule-special'),
  };

  if (!input) return;

  const rules = {
    length:  pw => pw.length >= 12,
    upper:   pw => /[A-Z]/.test(pw),
    lower:   pw => /[a-z]/.test(pw),
    number:  pw => /\d/.test(pw),
    special: pw => /[^A-Za-z0-9]/.test(pw),
  };

  const levels = [
    { label: 'Very Weak',  color: '#991b1b', text: 'Very Weak — try adding more characters' },
    { label: 'Weak',       color: '#dc2626', text: 'Weak — add uppercase and numbers' },
    { label: 'Fair',       color: '#f97316', text: 'Fair — getting there, add symbols' },
    { label: 'Strong',     color: '#84cc16', text: 'Strong — almost perfect!' },
    { label: 'Very Strong',color: '#22c55e', text: 'Very Strong — excellent password! ✓' },
  ];

  function checkStrength(pw) {
    if (!pw) {
      fill.style.width = '0%';
      fill.style.background = '';
      label.textContent = 'Enter a password above';
      label.style.color = '';
      Object.values(ruleEls).forEach(el => el?.classList.remove('valid'));
      Object.keys(ruleEls).forEach(k => {
        const icon = ruleEls[k]?.querySelector('.pw-rule__icon');
        if (icon) icon.textContent = '✕';
      });
      return;
    }

    let score = 0;
    Object.entries(rules).forEach(([key, fn]) => {
      const passes = fn(pw);
      if (passes) score++;
      ruleEls[key]?.classList.toggle('valid', passes);
      const icon = ruleEls[key]?.querySelector('.pw-rule__icon');
      if (icon) icon.textContent = passes ? '✓' : '✕';
    });

    /* Bonus for length */
    if (pw.length >= 16) score = Math.min(score + 0.5, 5);

    const idx   = Math.min(Math.floor(score) - 1, 4);
    const level = levels[Math.max(0, idx)];
    const pct   = `${Math.max(10, (score / 5) * 100)}%`;

    fill.style.width      = pct;
    fill.style.background = level.color;
    label.textContent     = level.text;
    label.style.color     = level.color;
  }

  input.addEventListener('input', () => checkStrength(input.value));

  /* Toggle show/hide */
  if (toggle) {
    toggle.addEventListener('click', () => {
      const isText = input.type === 'text';
      input.type = isText ? 'password' : 'text';
      toggle.setAttribute('aria-label', isText ? 'Show password' : 'Hide password');
      toggle.style.opacity = isText ? '' : '1';
    });
  }
})();


/* ================================================
   5. NEWSLETTER SUBSCRIBE
   ================================================ */
function handleSubscribe(e) {
  e.preventDefault();
  const emailInput = $('#subscribe-email');
  const btn        = $('#subscribe-btn');
  const email      = emailInput?.value?.trim();
  if (!email || !btn) return;

  btn.textContent = 'Subscribed ✓';
  btn.style.background = '#22c55e';
  btn.style.pointerEvents = 'none';
  emailInput.value = '';
  emailInput.disabled = true;

  setTimeout(() => {
    btn.textContent = 'Subscribe';
    btn.style.background = '';
    btn.style.pointerEvents = '';
    emailInput.disabled = false;
  }, 4000);
}

/* Expose globally for inline onsubmit */
window.handleSubscribe = handleSubscribe;


/* ================================================
   6. ANIMATED STAT COUNTER
   ================================================ */
(function initCounter() {
  const statEl = $('#stat-attacks');
  if (!statEl) return;

  const target  = 2244;
  const duration = 2200;

  const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
      if (!entry.isIntersecting) return;
      observer.unobserve(entry.target);

      let start = null;
      const step = ts => {
        if (!start) start = ts;
        const progress = Math.min((ts - start) / duration, 1);
        /* Ease out quad */
        const eased = 1 - (1 - progress) * (1 - progress);
        statEl.textContent = Math.round(eased * target).toLocaleString();
        if (progress < 1) requestAnimationFrame(step);
      };
      requestAnimationFrame(step);
    });
  }, { threshold: 0.5 });

  observer.observe(statEl);
})();


/* ================================================
   7. ACTIVE NAV LINK HIGHLIGHT ON SCROLL
   ================================================ */
(function initActiveNav() {
  const sections = $$('section[id]');
  const links    = $$('.nav__link');

  const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        const id = entry.target.id;
        links.forEach(link => {
          const isActive = link.getAttribute('href') === `#${id}`;
          link.style.color = isActive ? 'var(--primary)' : '';
          if (isActive) {
            link.style.setProperty('--link-active', '1');
          }
        });
      }
    });
  }, { threshold: 0.4, rootMargin: `-${68}px 0px 0px 0px` });

  sections.forEach(s => observer.observe(s));
})();
