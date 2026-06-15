/**
 * iQOO Website — Interactive Scripts
 * Scroll reveals, navigation, benchmark animations
 */

document.addEventListener('DOMContentLoaded', () => {

  // ========== NAVIGATION SCROLL EFFECT ==========
  const nav = document.getElementById('main-nav');
  let lastScrollY = 0;

  const handleNavScroll = () => {
    const scrollY = window.scrollY;
    if (scrollY > 60) {
      nav.classList.add('scrolled');
    } else {
      nav.classList.remove('scrolled');
    }
    lastScrollY = scrollY;
  };

  window.addEventListener('scroll', handleNavScroll, { passive: true });

  // ========== MOBILE NAV TOGGLE ==========
  const hamburger = document.getElementById('hamburger-btn');
  const mobileNav = document.getElementById('mobile-nav');

  if (hamburger && mobileNav) {
    hamburger.addEventListener('click', () => {
      const isOpen = mobileNav.classList.toggle('open');
      hamburger.classList.toggle('active');
      hamburger.setAttribute('aria-expanded', isOpen ? 'true' : 'false');
      document.body.style.overflow = isOpen ? 'hidden' : '';
    });

    // Close mobile nav on link click
    mobileNav.querySelectorAll('.mobile-nav__link').forEach(link => {
      link.addEventListener('click', () => {
        mobileNav.classList.remove('open');
        hamburger.classList.remove('active');
        hamburger.setAttribute('aria-expanded', 'false');
        document.body.style.overflow = '';
      });
    });
  }

  // ========== SMOOTH SCROLL FOR ANCHOR LINKS ==========
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', (e) => {
      const targetId = anchor.getAttribute('href');
      if (targetId === '#') return;
      const target = document.querySelector(targetId);
      if (target) {
        e.preventDefault();
        target.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    });
  });

  // ========== SCROLL REVEAL ==========
  const revealElements = document.querySelectorAll('.reveal');

  const revealObserver = new IntersectionObserver(
    (entries) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          entry.target.classList.add('visible');
          revealObserver.unobserve(entry.target);
        }
      });
    },
    {
      threshold: 0.15,
      rootMargin: '0px 0px -50px 0px',
    }
  );

  revealElements.forEach(el => revealObserver.observe(el));

  // ========== BENCHMARK BAR ANIMATION ==========
  const benchmarkBars = document.querySelectorAll('.benchmark-bar__fill');

  const benchmarkObserver = new IntersectionObserver(
    (entries) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          const fill = entry.target;
          const targetWidth = getComputedStyle(fill).getPropertyValue('--target-width').trim();
          fill.style.width = targetWidth;
          fill.classList.add('animated');
          benchmarkObserver.unobserve(fill);
        }
      });
    },
    {
      threshold: 0.3,
    }
  );

  benchmarkBars.forEach(bar => benchmarkObserver.observe(bar));

  // ========== HERO BUTTON ACTIONS ==========
  const heroExploreBtn = document.getElementById('hero-explore-btn');
  const heroSpecsBtn = document.getElementById('hero-specs-btn');

  if (heroExploreBtn) {
    heroExploreBtn.addEventListener('click', () => {
      document.getElementById('features')?.scrollIntoView({ behavior: 'smooth' });
    });
  }

  if (heroSpecsBtn) {
    heroSpecsBtn.addEventListener('click', () => {
      document.getElementById('specs')?.scrollIntoView({ behavior: 'smooth' });
    });
  }

  // ========== NAV CTA ==========
  const navCta = document.getElementById('nav-cta');
  if (navCta) {
    navCta.addEventListener('click', () => {
      document.getElementById('specs')?.scrollIntoView({ behavior: 'smooth' });
    });
  }

  // ========== MANIFESTO CTA ==========
  const manifestoCta = document.getElementById('manifesto-cta');
  if (manifestoCta) {
    manifestoCta.addEventListener('click', () => {
      document.getElementById('footer')?.scrollIntoView({ behavior: 'smooth' });
    });
  }

  // ========== PARALLAX PRISMS (subtle) ==========
  const prisms = document.querySelectorAll('.prism');

  const handlePrismParallax = () => {
    const scrollY = window.scrollY;
    prisms.forEach((prism, i) => {
      const speed = 0.02 + (i * 0.01);
      const yOffset = scrollY * speed;
      prism.style.transform = `translateY(${yOffset}px)`;
    });
  };

  window.addEventListener('scroll', handlePrismParallax, { passive: true });

  // ========== VIDEO FALLBACK ==========
  // If the hero video fails to load, gracefully hide the wrapper
  const heroVideo = document.querySelector('.hero__video');
  if (heroVideo) {
    heroVideo.addEventListener('error', () => {
      // Video didn't load — the glass overlay still looks great on its own
      heroVideo.style.display = 'none';
    }, true);
  }

});
