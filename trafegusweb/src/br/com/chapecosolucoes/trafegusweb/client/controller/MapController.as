package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.view.MapView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import com.google.maps.MapMouseEvent;
	import com.google.maps.controls.ControlPosition;
	import com.google.maps.controls.MapTypeControl;
	import com.google.maps.controls.ZoomControl;
	import com.google.maps.controls.ZoomControlOptions;
	import com.google.maps.overlays.Marker;
	import com.google.maps.overlays.MarkerOptions;
	import com.google.maps.examples.TooltipOverlay;
	
	import flash.events.Event;

	public class MapController
	{
		public function MapController()
		{
		}
		public var view:MapView;
		[Embed(source="/assets/caminhao_verde.png")]
		private var IconeCaminhaoVerde:Class;
		
		[Embed(source="/assets/caminhao_amarelo.png")]
		private var IconeCaminhaoAmarelo:Class;
		public function onMapReady(e:Event):void
		{
			this.view.map.enableScrollWheelZoom();
			this.view.map.enableContinuousZoom();
			this.view.map.addControl(new ZoomControl(new ZoomControlOptions({position: new ControlPosition(ControlPosition.ANCHOR_TOP_LEFT)})));
			this.view.map.addControl(new MapTypeControl());
		}
		public function createMarker(posicaoVeiculoVO:PosicaoVeiculoVO):Marker
		{
			var makerOp:MarkerOptions = new MarkerOptions();
			if (posicaoVeiculoVO.ignition == 0)
				makerOp.icon = new IconeCaminhaoAmarelo();
			else
				makerOp.icon = new IconeCaminhaoVerde();
			var marker:Marker = new Marker(posicaoVeiculoVO.latLong, makerOp);
			var tooltip:TooltipOverlay = new TooltipOverlay(posicaoVeiculoVO.latLong, posicaoVeiculoVO.gpsDescSis);
			marker.addEventListener(MapMouseEvent.CLICK, function(e:MapMouseEvent):void
			{
				this.view.map.setCenter(e.latLng,15);
			}); 
			marker.addEventListener(MapMouseEvent.ROLL_OVER, function(e:MapMouseEvent):void
			{
				this.view.map.addOverlay(tooltip);
			});
			marker.addEventListener(MapMouseEvent.ROLL_OUT, function(e:MapMouseEvent):void
			{
				this.view.map.removeOverlay(tooltip);
			});
			return marker;
		}
	}
}