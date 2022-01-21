$(".main-menu").on({
    mouseenter: function () {
        $(this).children('ul').show();
    },
    mouseleave: function () {
        $(this).children('ul').hide();
    }
});

$(".nav-box").on({
    mouseenter: function () {
        $(this).parent().children('a').toggleClass('sel');
        $(this).show();
    },
    mouseleave: function () {
        $(this).parent().children('a').toggleClass('sel');
        $(this).hide();
    }
});

$(".nav-box").find('li').on({
    mouseenter: function () {
        $(this).toggleClass('sel');
    },
    mouseleave: function () {
        $(this).toggleClass('sel');
    }
});

$(document).ready(function () {
    $(".main-menu").each(function (index, item) {
        let href = $(this).children('a').attr('href').split('/')[1];
        if (window.location.pathname.split('/')[1].includes(href)) {
            $(this).children('a').addClass('here');
        }
    });
});
