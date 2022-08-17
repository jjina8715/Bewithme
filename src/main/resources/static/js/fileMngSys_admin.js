function fn_click_image_to_delete() {
	$('div.image_panel').click(function(){
		var $attrId = $(this).attr("id");
		$('div[id=' + $attrId +']').hide();
		});
}