package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class DistanciaEntreVeiculosController
	{
		public function DistanciaEntreVeiculosController()
		{
		}
		public var view:DistanciaEntreVeiculosView;
		public function closeHandler():void
		{
			MyPopUpManager.removePopUp(this.view);			
		}
		public function veiculo1ZoomDispatcher():void
		{
			var posicaoVeiculoZoom:PosicaoVeiculoZoom = new PosicaoVeiculoZoom();
			posicaoVeiculoZoom.excluirVeiculoListaZoom = this.view.veiculo2Zoom.detail;
			posicaoVeiculoZoom.addEventListener(PosicaoVeiculoSelecionadaEvent.POSICAO_VEICULO_SELECIONADA_EVENT,posicaoVeiculo1SelecionadaEventHandler);
			MyPopUpManager.addPopUp(posicaoVeiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(posicaoVeiculoZoom);
		}
		public function veiculo2ZoomDispatcher():void
		{
			var posicaoVeiculoZoom:PosicaoVeiculoZoom = new PosicaoVeiculoZoom();
			posicaoVeiculoZoom.excluirVeiculoListaZoom = this.view.veiculo1Zoom.detail;
			posicaoVeiculoZoom.addEventListener(PosicaoVeiculoSelecionadaEvent.POSICAO_VEICULO_SELECIONADA_EVENT,posicaoVeiculo2SelecionadaEventHandler);
			MyPopUpManager.addPopUp(posicaoVeiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(posicaoVeiculoZoom);
		}
		private function posicaoVeiculo1SelecionadaEventHandler(event:PosicaoVeiculoSelecionadaEvent):void
		{
			this.view.veiculo1Zoom.cod = event.posicaoVeiculoVO.codVeic;
			this.view.veiculo1Zoom.detail = event.posicaoVeiculoVO.vehiclePlate;
		}
		private function posicaoVeiculo2SelecionadaEventHandler(event:PosicaoVeiculoSelecionadaEvent):void
		{
			this.view.veiculo2Zoom.cod = event.posicaoVeiculoVO.codVeic;
			this.view.veiculo2Zoom.detail = event.posicaoVeiculoVO.vehiclePlate;
		}
		public function veiculosSelecionados():void
		{
			
		}
	}
}