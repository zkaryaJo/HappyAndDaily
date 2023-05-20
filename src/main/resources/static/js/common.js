document.addEventListener('DOMContentLoaded', function() {
    var toggleBtn;
    var nav = document.querySelector('.header_nav_bar');

    // 장바구니, 위시리스트 버튼 hover
    var contentItems = document.querySelectorAll('.content_item_wrapper');

    for (var i = 0; i < contentItems.length; i++) {
        contentItems[i].addEventListener('mouseover', function() {
            var buttonWrapper = this.querySelector('.content_item_button_wrapper');
            buttonWrapper.classList.remove('hide');
        });

        contentItems[i].addEventListener('mouseout', function() {
            var buttonWrapper = this.querySelector('.content_item_button_wrapper');
            buttonWrapper.classList.add('hide');
        });
    }

    // System Menu 클릭 이벤트
    var navDropdown = document.querySelectorAll('.nav_dropdown');
    var dropdownLists = document.querySelectorAll('.header_nav_dropdown_list');

    navDropdown.forEach(function(dropdown) {
        dropdown.addEventListener('click', function(event) {
            var dropdownList = this.querySelector('.header_nav_dropdown_list');
            var isHidden = dropdownList.classList.contains('hide');
            dropdownLists.forEach(function(list) {
                list.classList.add('hide');
            });
            if (isHidden) {
                dropdownList.classList.remove('hide');
            }
            event.stopPropagation();
        });
    });

    document.addEventListener('click', function(event) {
        dropdownLists.forEach(function(dropdownList) {
            if (!dropdownList.contains(event.target)) {
                dropdownList.classList.add('hide');
            }
        });
    });

    // 작은 화면일 때 토글 버튼 클릭 이벤트
    var toggleButton = document.querySelector('.header_nav_toggle');
    var navBar = document.querySelector('.header_nav_bar');

    toggleButton.addEventListener('click', function() {
        navBar.classList.toggle('show');
    });

    document.addEventListener('click', function(event) {
        if (!navBar.contains(event.target) && !toggleButton.contains(event.target)) {
            navBar.classList.remove('show');
        }
    });

    // 화면의 크기에 따라 메뉴 인터렉션
    function startObserver() {
        toggleBtn = document.querySelector('.header_nav_toggle');
        if (toggleBtn) {
            checktoggleBtnDisplay();
        }
    }

    function checktoggleBtnDisplay() {
        if (getComputedStyle(toggleBtn).display === 'none') {
            if (nav.classList.contains('show')) {
                nav.classList.remove('show');
            }
        }
    }
    startObserver();
    window.addEventListener('resize', function() {
        checktoggleBtnDisplay();
    });
});