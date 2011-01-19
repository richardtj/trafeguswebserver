package br.com.chapecosolucoes.trafegusweb.client.utils
{
	import com.google.maps.LatLng;

	public class PolyLineMidPoint
	{
		public function PolyLineMidPoint()
		{
		}
		/**
		 * Returns the midpoint between this point and the supplied point.
		 *   see http://mathforum.org/library/drmath/view/51822.html for derivation
		 *
		 * @param   {LatLon} p1: Latitude/longitude of start point
		 * @param   {LatLon} p2: Latitude/longitude of end point
		 * @returns {LatLon} Midpoint between this point and the supplied points
		 */
		public static function midpointTo(p1:LatLng,p2:LatLng):LatLng
		{
			var lat1:Number = p1.latRadians();
			var lon1:Number = p1.lngRadians();
			var lat2:Number = p2.latRadians();
			var dLon:Number = ((p2.lng() - p1.lng()) * Math.PI/180);
			
			var Bx:Number = Math.cos(lat2) * Math.cos(dLon);
			var By:Number = Math.cos(lat2) * Math.sin(dLon);
			
			var lat3:Number = Math.atan2(Math.sin(lat1)+Math.sin(lat2),
				Math.sqrt( (Math.cos(lat1)+Bx)*(Math.cos(lat1)+Bx) + By*By) );
			var lon3:Number = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
			
			var lat3Deg:Number = lat3 * 180/Math.PI;
			var lon3Deg:Number = lon3 * 180/Math.PI;
			
			return new LatLng(lat3Deg,lon3Deg);
		}
		/*LatLon.prototype.midpointTo = function(point) {
			lat1 = this._lat.toRad(), lon1 = this._lon.toRad();
			lat2 = point._lat.toRad();
			var dLon = (point._lon-this._lon).toRad();
			
			var Bx = Math.cos(lat2) * Math.cos(dLon);
			var By = Math.cos(lat2) * Math.sin(dLon);
			
			lat3 = Math.atan2(Math.sin(lat1)+Math.sin(lat2),
				Math.sqrt( (Math.cos(lat1)+Bx)*(Math.cos(lat1)+Bx) + By*By) );
			lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
			
			return new LatLon(lat3.toDeg(), lon3.toDeg());
		}*/

	}
}