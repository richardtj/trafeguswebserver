package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.MapView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import com.google.maps.MapMouseEvent;
	import com.google.maps.controls.ControlPosition;
	import com.google.maps.controls.MapTypeControl;
	import com.google.maps.controls.ZoomControl;
	import com.google.maps.controls.ZoomControlOptions;
	import com.google.maps.examples.TooltipOverlay;
	import com.google.maps.overlays.Marker;
	import com.google.maps.overlays.MarkerOptions;
	
	import flash.events.Event;

	public class MapController
	{
		public function MapController()
		{
		}
		public var view:MapView;
		public function onMapReady(e:Event):void
		{
			this.view.map.enableScrollWheelZoom();
			this.view.map.enableContinuousZoom();
			this.view.map.addControl(new ZoomControl(new ZoomControlOptions({position: new ControlPosition(ControlPosition.ANCHOR_TOP_LEFT)})));
			this.view.map.addControl(new MapTypeControl());
			
			MainModel.getInstance().mapReady = true;
			if(MainModel.getInstance().posVeiculosArray != null && MainModel.getInstance().posVeiculosArray.length > 0)
			{
				this.view.posicaoVeiculosArray(MainModel.getInstance().posVeiculosArray);
			}
		}
		public function mapMouseEventHandler(e:MapMouseEvent):void{
			this.view.map.setCenter(e.latLng,15);
		}
	}
}