function sub() {
	var id = $('#id').val();
	var form = $('#form');
	if (id != '' && id != null) {
		form.attr('action', '/update');
	} else {
		form.attr('action', '/add');
	}
	form.submit();
}