$.ajaxSettings.async = false; 
$(function() {
	$.post(
		'/list',
		function(data) {
			var len = data.length;
			for(var i = 0; i < len; i++) {
				$('#list').append('id : <span>' + data[i].id + '</span>　 name : <span>' + data[i].name + '</span>' +
						'<a href="/delete?id=' + data[i].id + '">删除</a>　<a href="/add/page?id=' + data[i].id + '">修改</a><br/>');
			}
		}
	);
});

