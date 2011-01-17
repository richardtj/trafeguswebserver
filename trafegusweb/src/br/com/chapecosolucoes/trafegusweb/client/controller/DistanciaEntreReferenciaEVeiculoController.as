package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciaEVeiculoView;
	
	import flash.display.DisplayObject;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.core.FlexGlobals;

	public class DistanciaEntreReferenciaEVeiculoController extends BaseZoomController
	{
		public function DistanciaEntreReferenciaEVeiculoController()
		{
		}
		public function referenciaEVeiculoSelecionados():void
		{
			
		}
		public function veiculoZoomDispatcher():void
		{
			var posicaoVeiculoZoom:PosicaoVeiculoZoom = new PosicaoVeiculoZoom();
			posicaoVeiculoZoom.addEventListener(PosicaoVeiculoSelecionadaEvent.POSICAO_VEICULO_SELECIONADA_EVENT,posicaoVeiculoSelecionadaEventHandler);
			MyPopUpManager.addPopUp(posicaoVeiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(posicaoVeiculoZoom);
		}
		private function posicaoVeiculoSelecionadaEventHandler(event:PosicaoVeiculoSelecionadaEvent):void
		{
			this.view.veiculoZoom.cod = event.posicaoVeiculoVO.codVeic;
			this.view.veiculoZoom.detail = event.posicaoVeiculoVO.vehiclePlate;
		}
		public function referenciaZoomDispatcher():void
		{
			var referenciaZoom:ReferenciaZoom = new ReferenciaZoom();
			referenciaZoom.addEventListener(ReferenciaSelecionadaEvent.REFERENCIA_SELECIONADA_EVENT,referenciaSelecionadaEventHandler);
			MyPopUpManager.addPopUp(referenciaZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(referenciaZoom);
		}
		private function referenciaSelecionadaEventHandler(event:ReferenciaSelecionadaEvent):void
		{
			this.view.referenciaZoom.cod = event.referenciaVO.codigo;
			this.view.referenciaZoom.detail = event.referenciaVO.refeDescricao;
		}
	}
}