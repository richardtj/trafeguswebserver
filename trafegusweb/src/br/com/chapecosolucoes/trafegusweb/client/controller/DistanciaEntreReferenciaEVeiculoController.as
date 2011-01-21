package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciaEVeiculoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreVeiculosSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.DistanciaEntreReferenciaEVeiculoModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciaEVeiculoView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciaEVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVeiculosVO;
	
	import flash.display.DisplayObject;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.core.FlexGlobals;

	public class DistanciaEntreReferenciaEVeiculoController extends BaseZoomController
	{
		public function DistanciaEntreReferenciaEVeiculoController()
		{
		}
		public var model:DistanciaEntreReferenciaEVeiculoModel;
		public function referenciaEVeiculoSelecionados():void
		{
			var distanciaEntreVeiculoEReferencia:DistanciaDeAteReferenciaEVeiculoVO = new DistanciaDeAteReferenciaEVeiculoVO(this.model.posicaoVeiculoVO,this.model.referenciaVO);
			var event:DistanciaEntreReferenciaEVeiculoSelecionadoEvent = new DistanciaEntreReferenciaEVeiculoSelecionadoEvent(DistanciaEntreReferenciaEVeiculoSelecionadoEvent.DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_ADICIONADA_EVENT,distanciaEntreVeiculoEReferencia);
			this.view.dispatchEvent(event);
			this.closeHandler();
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
			this.model.posicaoVeiculoVO = event.posicaoVeiculoVO;
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
			this.model.referenciaVO = event.referenciaVO;
		}
	}
}