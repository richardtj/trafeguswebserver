package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.utils.PolyLineMidPoint;
	
	import com.google.maps.LatLng;
	import com.google.maps.examples.TooltipOverlay;
	import com.google.maps.overlays.Marker;
	import com.google.maps.overlays.Polyline;
	
	import mx.formatters.NumberFormatter;
	import mx.utils.ObjectUtil;

	[Bindable]
	public class DistanciaDeAteVO
	{
		public var numberFormatter:NumberFormatter;
		public function DistanciaDeAteVO(de:Object,ate:Object)
		{
			numberFormatter = new NumberFormatter();
			numberFormatter.precision = 2;
			this.de = de;
			this.ate = ate;
			this.meio = PolyLineMidPoint.midpointTo(de.latLong,ate.latLong);
		}
		public function distanciaDeAte():String
		{
			return "Km: " + numberFormatter.format(this.de.latLong.distanceFrom(this.ate.latLong)/1000);
		}
		public function getHtml():String
		{
			return "";
		}
		
			
		
		public var de:Object;
		public var ate:Object;
		public var meio:LatLng;
		public var marker:Marker;
		public var tooltip:TooltipOverlay;
		public var polyLine:Polyline;
	}
}