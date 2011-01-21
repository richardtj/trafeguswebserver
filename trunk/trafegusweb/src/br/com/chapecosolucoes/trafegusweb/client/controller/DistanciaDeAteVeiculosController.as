package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreVeiculosSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.LimparDistanciasEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVeiculosVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.core.FlexGlobals;
	import mx.events.ListEvent;
	
	public class DistanciaDeAteVeiculosController extends BaseZoomController
	{
		public function DistanciaDeAteVeiculosController()
		{
			super();
		}
		public function distanciaEntreVeiculosFilterFunction(item:Object):Boolean
		{
			return (String(PosicaoVeiculoVO(DistanciaDeAteVeiculosVO(item).de).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteVeiculosVO(item).de).gpsDescSis).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteVeiculosVO(item).de).dataEHora).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteVeiculosVO(item).ate).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteVeiculosVO(item).ate).gpsDescSis).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PosicaoVeiculoVO(DistanciaDeAteVeiculosVO(item).ate).dataEHora).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DistanciaDeAteVO(item).distanciaDeAte()).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
				
		}
		public function adicionar():void
		{
			var distanciaEntreVeiculos:DistanciaEntreVeiculosView = new DistanciaEntreVeiculosView();
			distanciaEntreVeiculos.addEventListener(DistanciaEntreVeiculosSelecionadaEvent.DISTANCIA_ENTRE_VEICULOS_ADICIONADA_EVENT,distanciaEntreVeiculosAdicionadaEventHandler);
			MyPopUpManager.addPopUp(distanciaEntreVeiculos,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(distanciaEntreVeiculos);
		}
		private function distanciaEntreVeiculosAdicionadaEventHandler(event:DistanciaEntreVeiculosSelecionadaEvent):void
		{
			this.view.dispatchEvent(event.clone());
		}
		public function remover():void
		{
			var event:LimparDistanciasEvent = new LimparDistanciasEvent(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,new ArrayCollection(this.view.grid.selectedItems));
			this.view.dispatchEvent(event);
		}
		public function itemClickEventHandler(event:ListEvent):void
		{
			var distanciaEntreVeiculosSelecionadaEvent:DistanciaEntreVeiculosSelecionadaEvent = new DistanciaEntreVeiculosSelecionadaEvent(DistanciaEntreVeiculosSelecionadaEvent.DISTANCIA_ENTRE_VEICULOS_SELECIONADA_EVENT,DistanciaDeAteVeiculosVO(event.itemRenderer.data));
			this.view.dispatchEvent(distanciaEntreVeiculosSelecionadaEvent);
		}
	}
}