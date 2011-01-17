package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	
	public class DistanciaEntreReferenciasController extends BaseZoomController
	{
		public function DistanciaEntreReferenciasController()
		{
		}
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
			this.view.referencia1Zoom.cod = event.referenciaVO.codigo;
			this.view.referencia1Zoom.detail = event.referenciaVO.refeDescricao;
		}
		private function referencia2SelecionadaEventHandler(event:ReferenciaSelecionadaEvent):void
		{
			this.view.referencia2Zoom.cod = event.referenciaVO.codigo;
			this.view.referencia2Zoom.detail = event.referenciaVO.refeDescricao;
		}
		public function referenciasSelecionados():void
		{
			
		}
	}
}