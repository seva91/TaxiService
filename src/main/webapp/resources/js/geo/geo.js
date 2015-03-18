function AddressMap() {
	var map = new ymaps.Map("map", {
        center: [55.76, 37.64],
        zoom: 12
    });
	
	this.changeCity = function(x, y){
		map.setCenter(
			[x, y],
			12
		);
		this_.placeMark = createPlaceMark(this_.placeMark);
	};
	
	var this_ = this;
	this.placeMark = createPlaceMark(null);
	
	function createPlaceMark(old) {
		if (old != null) {
			map.geoObjects.remove(old);
		}
		
		var placemark_ = new ymaps.Placemark(
			map.getCenter(), 
			{ },
			{ draggable: true }
		);
		
		placemark_.events.add("drag", function(event){
			var coord = placemark_.geometry.getCoordinates();
			$('#lat').val(coord[0]);
			$('#lon').val(coord[1]);
		});
		
		map.geoObjects.add(placemark_);
		
		return placemark_;
	}
	
	this.setPlaceMark = function() {
		
	}
}