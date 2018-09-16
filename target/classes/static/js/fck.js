$(function() {
    $.post(
        '/fck/get_all_id',
        function(data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                $('#listid').append('<li><a href="JavaScript:void(0);" onclick="setin(\'' + data[i] +'\')">' + data[i] + '</a></li>');
            }

        }
    )
});

//获取内容
function onon() {
    var val = CKEDITOR.instances.editor.getData();
    if (val.length == 0) {
        alert("空白");
    }
    else {
        console.log(val);
        $('#text').val(val);
        $('#fck').submit();
    }
}

//设置内容
function setin(id) {
    $.post(
        '/fck/get_one?id=' + id,
        function (data) {
            console.log(data);
            $('#id').val(data.id);
            CKEDITOR.instances.editor.setData(data.text);
        }
    )

}

//导出word
function exportWord() {
    var id = $('#id').val();
    location = '/fck/export?id=' + id;
}