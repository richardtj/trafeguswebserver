package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreVeiculosSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ZoomCodDetailEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.DistanciaEntreVeiculosModel;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVeiculosVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.rpc.events.ResultEvent;

	public class DistanciaEntreVeiculosController
	{
		public function DistanciaEntreVeiculosController()
		{
		}
		public var view:DistanciaEntreVeiculosView;
		public var model:DistanciaEntreVeiculosModel;
		public function closeHandler():void
		{
			MyPopUpManager.removePopUp(this.view);			
		}
		public function veiculo1ZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var posicaoVeiculoZoom:PosicaoVeiculoZoom = new PosicaoVeiculoZoom();
				posicaoVeiculoZoom.excluirVeiculoListaZoom = this.view.veiculo2Zoom.detail;
				posicaoVeiculoZoom.addEventListener(PosicaoVeiculoSelecionadaEvent.POSICAO_VEICULO_SELECIONADA_EVENT,posicaoVeiculo1SelecionadaEventHandler);
				MyPopUpManager.addPopUp(posicaoVeiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(posicaoVeiculoZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoVeiculo(solicitaDescricaoVeiculo1ResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoVeiculo1ResultHandler(event:ResultEvent):void
		{			
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.model.veiculoDe.vehiclePlate = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.model.veiculoDe.setPosicaoVeiculoVO(obj);
			}
			TrafegusWS.getIntance().removeEventListener("solicitaDescricaoVeiculo",this.solicitaDescricaoVeiculo1ResultHandler);
		}
		private function solicitaDescricaoVeiculo2ResultHandler(event:ResultEvent):void
		{			
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				this.model.veiculoAte.vehiclePlate = "";
			}
			for each (var obj:Object in resultArray)
			{
				this.model.veiculoAte.setPosicaoVeiculoVO(obj);
			}
			TrafegusWS.getIntance().removeEventListener("solicitaDescricaoVeiculo",this.solicitaDescricaoVeiculo2ResultHandler);
		}
		public function veiculo2ZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var posicaoVeiculoZoom:PosicaoVeiculoZoom = new PosicaoVeiculoZoom();
				posicaoVeiculoZoom.excluirVeiculoListaZoom = this.view.veiculo1Zoom.detail;
				posicaoVeiculoZoom.addEventListener(PosicaoVeiculoSelecionadaEvent.POSICAO_VEICULO_SELECIONADA_EVENT,posicaoVeiculo2SelecionadaEventHandler);
				MyPopUpManager.addPopUp(posicaoVeiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(posicaoVeiculoZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoVeiculo(solicitaDescricaoVeiculo2ResultHandler,event.cod);
			}
		}
		private function posicaoVeiculo1SelecionadaEventHandler(event:PosicaoVeiculoSelecionadaEvent):void
		{
			this.model.veiculoDe = event.posicaoVeiculoVO;
		}
		private function posicaoVeiculo2SelecionadaEventHandler(event:PosicaoVeiculoSelecionadaEvent):void
		{
			this.model.veiculoAte = event.posicaoVeiculoVO;
		}
		public function veiculosSelecionados():void
		{
			var distanciaEntreVeiculos:DistanciaDeAteVeiculosVO = new DistanciaDeAteVeiculosVO(this.model.veiculoDe,this.model.veiculoAte);
			var event:DistanciaEntreVeiculosSelecionadaEvent = new DistanciaEntreVeiculosSelecionadaEvent(DistanciaEntreVeiculosSelecionadaEvent.DISTANCIA_ENTRE_VEICULOS_ADICIONADA_EVENT,distanciaEntreVeiculos);
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}