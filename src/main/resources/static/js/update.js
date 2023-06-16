$(document).ready(function() {
    $('#savePolyclinic').click(function(event) {
        event.preventDefault();
        var form = $('#editPolyclinicForm');
        $.ajax({
            type: 'POST',
            url: form.attr('action'),
            data: form.serialize(),
            success: function(data) {
                // Обновление данных на странице
                $('#polyclinicName').text(data.name);
                $('#polyclinicAddress').text(data.address);
            },
            error: function() {
                alert('Ошибка при сохранении данных');
            }
        });
    });
});