function isIe() {
    if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)) {
        alert('����ʹ��IE')
    } else if (navigator.userAgent.indexOf('Firefox') >= 0) {
        alert('����ʹ��Firefox')
    } else if (navigator.userAgent.indexOf('Opera') >= 0) {
        alert('����ʹ��Opera')
    } else {
        alert('����ʹ������������������ҳ��')
    }
}