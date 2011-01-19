package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciasSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.DistanciaEntreReferenciasModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciaEVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciasVO;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	
	public class DistanciaEntreReferenciasController extends BaseZoomController
	{
		public function DistanciaEntreReferenciasController()
		{
		}
		public var model:DistanciaEntreReferenciasModel;
		public function referencia1ZoomDispatcher():void
		{
			var referenciaZoom:ReferenciaZoom = new ReferenciaZoom();
			referenciaZoom.excluirReferenciaListaZoom = this.view.referencia2Zoom.detail;
			referenciaZoom.addEventListener(ReferenciaSelecionadaEvent.REFERENCIA_SELECIONADA_EVENT,referencia1SelecionadaEventHandler);
			MyPopUpManager.addPopUp(referenciaZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(referenciaZoom);
		}
		public function referencia2ZoomDispatcher():void
		{
			var referenciaZoom:ReferenciaZoom = new ReferenciaZoom();
			referenciaZoom.excluirReferenciaListaZoom = this.view.referencia1Zoom.detail;
			referenciaZoom.addEventListener(ReferenciaSelecionadaEvent.REFERENCIA_SELECIONADA_EVENT,referencia2SelecionadaEventHandler);
			MyPopUpManager.addPopUp(referenciaZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(referenciaZoom);
		}
		private function referencia1SelecionadaEventHandler(event:ReferenciaSelecionadaEvent):void
		{
			this.model.referencia1VO = event.referenciaVO;
		}
		private function referencia2SelecionadaEventHandler(event:ReferenciaSelecionadaEvent):void
		{
			this.model.referencia2VO = event.referenciaVO;
		}
		public function referenciasSelecionados():void
		{
			var distanciaEntreReferenciasSelecionadaVO:DistanciaDeAteReferenciasVO = new DistanciaDeAteReferenciasVO(this.model.referencia1VO,this.model.referencia2VO);
			var event:DistanciaEntreReferenciasSelecionadaEvent = new DistanciaEntreReferenciasSelecionadaEvent(DistanciaEntreReferenciasSelecionadaEvent.DISTANCIA_ENTRE_REFERENCIAS_SELECIONADA_EVENT,distanciaEntreReferenciasSelecionadaVO);
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}