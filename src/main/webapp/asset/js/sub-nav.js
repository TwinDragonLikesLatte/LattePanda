for (let i = 0; i < document.querySelectorAll('.sub-menu>a').length; i++) {
    let sub_menu_title = (document.querySelectorAll('.sub-menu>a')[i]);
    let href = sub_menu_title.href.replace(location.origin, "").split("/");

    if (location.pathname.split('/')[2] == href[2]) {
        sub_menu_title.classList.add('here');
    }
};

for (let i = 0; i < document.querySelectorAll(".sub-menu li>a").length; i++) {
    let sub_menu_subtitle = (document.querySelectorAll(".sub-menu li>a")[i]);
    let href = sub_menu_subtitle.href.replace(location.origin, "").split("/");

    if (href[3].includes(location.pathname.split('/')[3].split('?')[0])) {
        let d = document.querySelectorAll(".sub-menu li>a")[i];
        d.classList.add('here');
    }
}