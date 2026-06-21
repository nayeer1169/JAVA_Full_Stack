document.addEventListener('DOMContentLoaded', () => {

  /* ========== DOM ELEMENTS ========== */
  const header = document.querySelector('.header');
  const hamburgerBtn = document.getElementById('hamburger-btn');
  const mobileMenu = document.getElementById('mobile-menu');
  const mobileLinks = document.querySelectorAll('.mobile-nav__link');
  
  const vehiclePreview = document.getElementById('vehicle-preview');
  const finishLabel = document.getElementById('active-finish-label');
  const previewGlow = document.getElementById('preview-glow-bg');
  
  const swatches = document.querySelectorAll('.swatch');
  const optionButtons = document.querySelectorAll('.btn-option');
  
  // Specs Elements
  const specPower = document.getElementById('spec-power');
  const specAccel = document.getElementById('spec-accel');
  const specSpeed = document.getElementById('spec-speed');
  
  const barPower = document.getElementById('bar-power');
  const barAccel = document.getElementById('bar-accel');
  const barSpeed = document.getElementById('bar-speed');

  /* ========== CONFIG STATE ========== */
  const baseSpecs = {
    power: 460,
    accel: 3.9,
    speed: 177
  };

  let currentSpecs = { ...baseSpecs };
  let selectedColor = 'blue';
  let selectedFinishName = 'Yas Marina Blue';
  let selectedWheelName = '19"/20" M Double-spoke Style 930 M Black';
  let trackPkgActive = false;
  let carbonPkgActive = false;

  /* ========== MOBILE NAVIGATION ========== */
  const toggleMobileNav = () => {
    const isActive = mobileMenu.classList.toggle('active');
    hamburgerBtn.classList.toggle('active');
    hamburgerBtn.setAttribute('aria-expanded', isActive);
  };

  hamburgerBtn.addEventListener('click', toggleMobileNav);
  
  mobileLinks.forEach(link => {
    link.addEventListener('click', () => {
      mobileMenu.classList.remove('active');
      hamburgerBtn.classList.remove('active');
      hamburgerBtn.setAttribute('aria-expanded', 'false');
    });
  });

  // Scroll transparency logic
  window.addEventListener('scroll', () => {
    if (window.scrollY > 50) {
      header.style.background = 'rgba(5, 7, 15, 0.85)';
      header.style.padding = '0.2rem 0';
    } else {
      header.style.background = 'rgba(5, 7, 15, 0.6)';
      header.style.padding = '0';
    }
  });

  /* ========== DYNAMIC SWATCHES CONTROL ========== */
  const colorMeta = {
    blue: {
      accent: '#38bdf8',
      glow: 'rgba(56, 189, 248, 0.25)',
      img: 'assets/bmw_blue.png'
    },
    red: {
      accent: '#ef4444',
      glow: 'rgba(239, 68, 68, 0.25)',
      img: 'assets/bmw_red.png'
    },
    black: {
      accent: '#64748b',
      glow: 'rgba(100, 116, 139, 0.25)',
      img: 'assets/bmw_black.png'
    }
  };

  swatches.forEach(swatch => {
    swatch.addEventListener('click', (e) => {
      const color = swatch.dataset.color;
      const finishName = swatch.dataset.finish;
      
      // Update Swatch Active State
      swatches.forEach(s => s.classList.remove('active'));
      swatch.classList.add('active');
      
      // State Update
      selectedColor = color;
      selectedFinishName = finishName;
      
      // Visual Feedback Transitions
      updateVehicleVisuals(color);
    });
  });

  const updateVehicleVisuals = (color) => {
    const meta = colorMeta[color];
    
    // Fade out image
    vehiclePreview.style.opacity = '0';
    vehiclePreview.style.transform = 'scale(0.98)';
    
    setTimeout(() => {
      // Swap Image src & Alt
      vehiclePreview.src = meta.img;
      vehiclePreview.alt = `BMW M2 Coupe ${selectedFinishName} with ${selectedWheelName}`;
      
      // Dynamic CSS Custom Properties injection
      document.documentElement.style.setProperty('--active-accent', meta.accent);
      document.documentElement.style.setProperty('--active-glow', meta.glow);
      
      // Fade back in
      vehiclePreview.style.opacity = '1';
      vehiclePreview.style.transform = 'scale(1)';
      
      // Update Info Label
      finishLabel.textContent = `Paint Finish: ${selectedFinishName} + ${selectedWheelName.split(' M ')[1] || 'Standard Wheels'}`;
    }, 200);
  };

  /* ========== WHEEL CONFIGURATION ========== */
  const wheelButtons = document.querySelectorAll('[data-wheel]');
  wheelButtons.forEach(btn => {
    btn.addEventListener('click', () => {
      wheelButtons.forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      
      selectedWheelName = btn.textContent.trim();
      
      // Trigger preview update
      finishLabel.textContent = `Paint Finish: ${selectedFinishName} + ${selectedWheelName.split(' M ')[1] || 'Standard Wheels'}`;
    });
  });

  /* ========== PERFORMANCE TUNING PACKAGES ========== */
  const pkgButtons = document.querySelectorAll('[data-package]');
  pkgButtons.forEach(btn => {
    btn.addEventListener('click', () => {
      const packageType = btn.dataset.package;
      const isSelected = btn.classList.toggle('active');

      if (packageType === 'track') {
        trackPkgActive = isSelected;
      } else if (packageType === 'carbon') {
        carbonPkgActive = isSelected;
      }

      calculateSpecs();
    });
  });

  /* ========== CALCULATE & ANIMATE SPECIFICATIONS ========== */
  const calculateSpecs = () => {
    let power = baseSpecs.power;
    let accel = baseSpecs.accel;
    let speed = baseSpecs.speed;

    if (trackPkgActive) {
      power += 40;  // Tuning adds 40 HP
      accel -= 0.2; // Shaves off 0.2s 0-60
      speed += 9;   // Unlocks top speed to 186 MPH
    }

    if (carbonPkgActive) {
      accel -= 0.1; // Carbon weight saving shaves off 0.1s
    }

    animateMetric(specPower, currentSpecs.power, power, 0, ' HP');
    animateMetric(specAccel, currentSpecs.accel, accel, 1, 's');
    animateMetric(specSpeed, currentSpecs.speed, speed, 0, ' MPH');

    // Update current states
    currentSpecs = { power, accel, speed };
    
    // Animate the progress bars matching targets
    updateProgressBars();
  };

  const animateMetric = (element, start, end, decimals = 0, suffix = '') => {
    let current = start;
    const duration = 800; // ms
    const startTime = performance.now();

    const animate = (currentTime) => {
      const elapsed = currentTime - startTime;
      const progress = Math.min(elapsed / duration, 1);
      
      // Ease Out Quad
      const ease = progress * (2 - progress);
      
      current = start + (end - start) * ease;
      element.textContent = current.toFixed(decimals);

      if (progress < 1) {
        requestAnimationFrame(animate);
      } else {
        element.textContent = end.toFixed(decimals);
      }
    };

    requestAnimationFrame(animate);
  };

  const updateProgressBars = () => {
    // Standardized Maxes for percentage mapping
    const maxPower = 600;
    const minAccel = 2.5;
    const maxAccel = 5.0;
    const maxSpeed = 220;

    // Power mapping (e.g. 460 HP = 76%)
    const powerPct = (currentSpecs.power / maxPower) * 100;
    barPower.style.width = `${powerPct}%`;

    // Acceleration inverse mapping (lower is better, e.g. 3.9s = 70%)
    const accelRange = maxAccel - minAccel;
    const accelPct = ((maxAccel - currentSpecs.accel) / accelRange) * 100;
    barAccel.style.width = `${accelPct}%`;

    // Speed mapping (e.g. 177 MPH = 80%)
    const speedPct = (currentSpecs.speed / maxSpeed) * 100;
    barSpeed.style.width = `${speedPct}%`;
  };

  /* ========== INTERSECTION OBSERVER FOR IN-VIEW ANIMATIONS ========== */
  const observerOptions = {
    threshold: 0.15
  };

  const specSection = document.getElementById('specs');
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        updateProgressBars();
        observer.unobserve(entry.target);
      }
    });
  }, observerOptions);

  observer.observe(specSection);
});
