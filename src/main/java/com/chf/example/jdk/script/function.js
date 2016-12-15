add = function(a, b) {
	return a + b;
}

max = function(a, b) {
	if (a > b) {
		return a;
	}
	return b;
}

dict = function(a, b) {
	return {
		click : a,
		click2 : 2,
		a : b
	};
}

array = function(a) {
	return [ a, a, a ];
}

null_func = function() {
	return;
}

obj_func = function(a) {
	return "result =" + a.str + " : " + a.num;
}
