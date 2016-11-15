function  showMessage(type,msg) {
		var IMG_PREFIX = '../img/';
		if(type=="info"){
	          Lobibox.notify('info', {
	              img: IMG_PREFIX + 'cg.jpg',
	              msg:msg
	          });
		}
		if(type=="warning"){
	          Lobibox.notify('warning', {
	              img: IMG_PREFIX + 'cg.jpg',
	              msg: msg
	          });
		}
	    if(type=="error"){
	          Lobibox.notify('error', {
	              img: IMG_PREFIX + 'cg.jpg',
	              msg: msg
	          });
	    }
	    if(type=="success"){
	          Lobibox.notify('success', {
	              img: IMG_PREFIX + 'cg.jpg',
	              msg: msg
	          });
	    }
}