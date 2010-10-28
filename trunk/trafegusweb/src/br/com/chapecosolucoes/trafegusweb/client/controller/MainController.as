package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.events.DetailsEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.MainView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import com.google.maps.LatLng;
	
	import mx.controls.Alert;

	public class MainController
	{
		public function MainController()
		{
		}
		public var view:MainView;
		public function addPoint():void
		{
			var obj:Object = new Object();
			obj.ignition = 0;
			obj.vehiclePlate = "AAA1234";
			obj.gpsDescSis = "teste xyz";
			obj.latLong = new LatLng(-15.779413016690475, -47.929744720458984);
			
			var posicaoVeiculoVO:PosicaoVeiculoVO = new PosicaoVeiculoVO(obj);
			MainModel.getInstance().posicaoVeiculoVO = posicaoVeiculoVO;
		}
		public function vehiclesReceivedEventHandler(event:VehiclesEvent):void
		{
			this.view.map.posicaoVeiculosArray(MainModel.getInstance().posVeiculosArray);
		}
		public function vehicleSelectedEventHandler(event:VehiclesEvent):void
		{
			this.view.map.posicaoVeiculoVO(MainModel.getInstance().posicaoVeiculoVO);
			this.view.details.posicaoVeiculoVO(MainModel.getInstance().posicaoVeiculoVO);
		}
		public function routeReceivedEventHandler(event:DetailsEvent):void
		{
			this.view.map.rotaVeiculo(MainModel.getInstance().historicoPosicoesVeiculosArray);
		}
	}
}