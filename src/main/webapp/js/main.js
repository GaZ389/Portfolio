function sendMenuForm(nextPage, param) {
    let form = document.getElementById('menuForm');
    form.firstElementChild.value = nextPage;
    form.lastElementChild.value = param;
    form.submit();
}

function sendDeleteNewsForm(id) {
    let form = document.getElementById("deleteNewsForm");
    form.firstElementChild.value = id;
    form.submit();
}