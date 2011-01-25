package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.EmbarcadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.LocaisZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.MotoristaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PGRZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.RotaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TipoTransporteZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TransportadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ViagemPaiZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.AddParadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedDriverEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedRouteEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoTransporteSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TransportadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ViagemPaiSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ZoomCodDetailEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddCarretasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddParadasView;
	import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;
	import mx.rpc.events.ResultEvent;
	
	import org.flexunit.runner.Result;

	public class MonitoringRequestController
	{
		public function MonitoringRequestController()
		{
		}
		public var view:MonitoringRequestWiew;
		public function veiculoZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var veiculoZoom:VeiculoZoom = new VeiculoZoom();
				veiculoZoom.addEventListener(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,selectedVehicleEventHandler);
				MyPopUpManager.addPopUp(veiculoZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(veiculoZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoVeiculo(solicitaDescricaoVeiculoResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.placaVeiculo = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.placaVeiculo = obj.placa.toString();
			}
			TrafegusWS.getIntance().removeEventListener("solicitaDescricaoVeiculo",this.solicitaDescricaoVeiculoResultHandler);
		}
		public function selectedVehicleEventHandler(event:SelectedVehicleEvent):void
		{
			MainModel.getInstance().smVO.codigoVeiculo = event.veiculo.cod;
			MainModel.getInstance().smVO.placaVeiculo = event.veiculo.vehiclePlate;
			this.view.dadosAdicionaisView.atualizaTerminais();
		}
		public function addCarretas():void
		{
			var addCarretasView:AddCarretasView = new AddCarretasView();
			MyPopUpManager.addPopUp(addCarretasView,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(addCarretasView);
		}
		public function addParadas():void
		{
			var addParadasView:AddParadasView = new AddParadasView();
			MyPopUpManager.addPopUp(addParadasView,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(addParadasView);
		}
		public function motoristaZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var motoristaZoom:MotoristaZoom = new MotoristaZoom();
				motoristaZoom.addEventListener(SelectedDriverEvent.SELECTED_DRIVER_EVENT,selectedDriverEventHandler);
				MyPopUpManager.addPopUp(motoristaZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(motoristaZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoMotorista(solicitaDescricaoMotoristaResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoMotoristaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.nomeMotorista = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.nomeMotorista = obj.pess_nome.toString();
			}
		}
		private function selectedDriverEventHandler(event:SelectedDriverEvent):void
		{
			MainModel.getInstance().smVO.codigoMotorista = event.motorista.codigo;
			MainModel.getInstance().smVO.nomeMotorista = event.motorista.motoristaPrincipal;
		}
		public function rotaZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var rotaZoom:RotaZoom = new RotaZoom();
				rotaZoom.addEventListener(SelectedRouteEvent.SELECTED_ROUTE_EVENT,selectedRouteEventHandler);
				MyPopUpManager.addPopUp(rotaZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(rotaZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoRota(solicitaDescricaoRotaResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoRotaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoRota = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoRota = obj.rota_descricao.toString();
			}
		}
		private function selectedRouteEventHandler(event:SelectedRouteEvent):void
		{
			MainModel.getInstance().smVO.codigoRota = event.route.codigo;
			MainModel.getInstance().smVO.descricaoRota = event.route.descricao;
			
			MainModel.getInstance().smVO.codigoOrigem = event.route.localOrigem.codigo;
			MainModel.getInstance().smVO.descricaoOrigem = event.route.localOrigem.descricao;
			
			MainModel.getInstance().smVO.codigoDestino = event.route.localDestino.codigo;
			MainModel.getInstance().smVO.descricaoDestino = event.route.localDestino.descricao;
		}
		public function embarcadoresZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var embarcadoresZoom:EmbarcadoresZoom = new EmbarcadoresZoom();
				embarcadoresZoom.addEventListener(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,embarcadorSelecionadoEventHandler);
				MyPopUpManager.addPopUp(embarcadoresZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(embarcadoresZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoEmbarcador(solicitaDescricaoEmbarcadorResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoEmbarcadorResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.nomeEmbarcador = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.nomeEmbarcador = obj.pess_nome.toString();
			}
		}
		private function embarcadorSelecionadoEventHandler(event:EmbarcadorSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoEmbarcador = event.embarcador.codigo;
			MainModel.getInstance().smVO.nomeEmbarcador = event.embarcador.nome;
		}
		public function locaisZoomDispatcher(enum:LocaisEnum,event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var locaisZoom:LocaisZoom = new LocaisZoom();
				if(enum == LocaisEnum.ORIGEM)
				{
					locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,origemSelecionadaEventHandler);
				}
				else if(enum == LocaisEnum.DESTINO)
				{
					locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,destinoSelecionadoEventHandler);
				}
				MyPopUpManager.addPopUp(locaisZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(locaisZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				if(enum == LocaisEnum.ORIGEM)
				{
					TrafegusWS.getIntance().solicitaDescricaoLocalOrigem(solicitaDescricaoLocalOrigemResultHandler,event.cod);
				}
				else if(enum == LocaisEnum.DESTINO)
				{
					TrafegusWS.getIntance().solicitaDescricaoLocalDestino(solicitaDescricaoLocalDestinoResultHandler,event.cod);
				}
			}
		}
		private function solicitaDescricaoLocalOrigemResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoOrigem = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoOrigem = obj.refe_descricao.toString();
			}
		}
		private function solicitaDescricaoLocalDestinoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoDestino = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoDestino = obj.refe_descricao.toString();
			}
		}
		private function origemSelecionadaEventHandler(event:SelectedLocalEvent):void
		{
			MainModel.getInstance().smVO.codigoOrigem = event.local.codigo;
			MainModel.getInstance().smVO.descricaoOrigem = event.local.descricao;
		}
		private function destinoSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			MainModel.getInstance().smVO.codigoDestino = event.local.codigo;
			MainModel.getInstance().smVO.descricaoDestino = event.local.descricao;
		}
		public function transportadorZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var transportadoresZoom:TransportadoresZoom = new TransportadoresZoom();
				transportadoresZoom.addEventListener(TransportadorSelecionadoEvent.TRANSPORTADOR_SELECIONADO_EVENT,transportadorSelecionadoEventHandler);
				MyPopUpManager.addPopUp(transportadoresZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(transportadoresZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoTransportador(solicitaDescricaoTransportadorResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoTransportadorResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.nomeTransportador = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.nomeTransportador = obj.pess_nome.toString();
			}
		}
		private function transportadorSelecionadoEventHandler(event:TransportadorSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoTransportador = event.transportador.codigo;
			MainModel.getInstance().smVO.nomeTransportador = event.transportador.nome;
		}
		public function tipoTransporteZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var tipoTransporteZoom:TipoTransporteZoom = new TipoTransporteZoom();
				tipoTransporteZoom.addEventListener(TipoTransporteSelecionadoEvent.TIPO_TRANSPORTE_SELECIONADO_EVENT,tipoTransporteSelecionadoEventHandler);
				MyPopUpManager.addPopUp(tipoTransporteZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(tipoTransporteZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoTipoTransporte(solicitaDescricaoTipoTransporteEventHandler,event.cod);
			}
		}
		private function solicitaDescricaoTipoTransporteEventHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoTipoViagem = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoTipoViagem = obj.ttra_descricao.toString();
			}
		}
		private function tipoTransporteSelecionadoEventHandler(event:TipoTransporteSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoTipoViagem = event.tipoTransporte.codigo;
			MainModel.getInstance().smVO.descricaoTipoViagem = event.tipoTransporte.descricao;
		}
		public function paradaSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			MainModel.getInstance().paradasArray.addItem(event.local);
		}
		/*public function removeParada():void
		{
			if(this.view.grid.selectedIndex != -1)
			{
				MainModel.getInstance().paradasArray.removeItemAt(MainModel.getInstance().paradasArray.getItemIndex(this.view.grid.selectedItem));
			}
			else
			{
				Alert.show("Nenhum item selecionado.");
			}				
		}*/
		public function addParadaZoomDispatcher():void
		{
			var addParada:AddParadasView = new AddParadasView();
			addParada.addEventListener(AddParadaEvent.PARADA_ADICIONADA_EVENT,paradaAdicionadaEventHandler);
			MyPopUpManager.addPopUp(addParada,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(addParada);
		}
		private function paradaAdicionadaEventHandler(event:AddParadaEvent):void
		{
			MainModel.getInstance().paradasArray.addItem(event.parada);
		}
		public function planoGRZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var pgrZoom:PGRZoom = new PGRZoom();
				pgrZoom.addEventListener(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,pgrSelecionadoEventHandler);
				MyPopUpManager.addPopUp(pgrZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(pgrZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoPGR(solicitaDescricaoPGRResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoPGRResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.descricaoPGR = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.descricaoPGR = obj.pgpg_descricao.toString();
			}
		}
		private function pgrSelecionadoEventHandler(event:PGRSelecionadoEvent):void
		{
			MainModel.getInstance().smVO.codigoPGR = event.pgr.codigo;
			MainModel.getInstance().smVO.descricaoPGR = event.pgr.descricao;
		}
		public function viagemPaiZoomDispatcher(event:ZoomCodDetailEvent):void
		{
			if(event.type == ZoomCodDetailEvent.CLICK)
			{
				var viagemPaiZoom:ViagemPaiZoom = new ViagemPaiZoom();
				viagemPaiZoom.addEventListener(ViagemPaiSelecionadaEvent.VIAGEM_PAI_SELECIONADA_EVENT,viagemPaiSelecionadaResultHandler);
				MyPopUpManager.addPopUp(viagemPaiZoom,DisplayObject(FlexGlobals.topLevelApplication));
				MyPopUpManager.centerPopUp(viagemPaiZoom);
			}
			else if(event.type == ZoomCodDetailEvent.TAB)
			{
				TrafegusWS.getIntance().solicitaDescricaoViagemPai(solicitaDescricaoViagemPaiResultHandler,event.cod);
			}
		}
		private function solicitaDescricaoViagemPaiResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			if(resultArray.length == 0)
			{
				MainModel.getInstance().smVO.previsaoInicioViagemPai = "";
				MainModel.getInstance().smVO.previsaoFimViagemPai = "";
			}
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().smVO.previsaoInicioViagemPai = obj.viag_previsao_inicio.toString();
				MainModel.getInstance().smVO.previsaoFimViagemPai = obj.viag_previsao_fim.toString();
			}
		}
		private function viagemPaiSelecionadaResultHandler(event:ViagemPaiSelecionadaEvent):void
		{
			MainModel.getInstance().smVO.codigoViagemPai = event.viagemPai.codigo;
			MainModel.getInstance().smVO.previsaoInicioViagemPai = event.viagemPai.previsaoInicio;
			MainModel.getInstance().smVO.previsaoFimViagemPai = event.viagemPai.previsaoFim;
		}
	}
}