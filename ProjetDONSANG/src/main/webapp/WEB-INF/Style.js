$newItemForm = $('#newItemForm')
$newItemForm.on('click', 'button',function(e) {
    e.preventDefault();
    var $value=
    $list.append('<li>' + text + '</li>');
    $('input:text').val('');
});