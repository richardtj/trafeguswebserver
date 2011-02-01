package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearch;
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearchHistoricoImpl;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesHistoricEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehiclesHistoricView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.AdvancedSearchHistoricoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.core.FlexGlobals;
	import mx.rpc.events.ResultEvent;
	
	public class VehiclesHistoricController
	{
		public function VehiclesHistoricController()
		{
			
		}
		public var view:VehiclesHistoricView;
		
		public function historicoFilterFunction(item:Object):Boolean
		{
			return (String(HistoricoPosicoesVeiculoVO(item).dataEHora).toUpperCase().search(MainModel.getInstance().historicoSelecionado.toUpperCase()) >= 0) ||
				(String(HistoricoPosicoesVeiculoVO(item).gpsDescSis).toUpperCase().search(MainModel.getInstance().historicoSelecionado.toUpperCase()) >= 0);
		}
		
		public function solicitaHistoricoPosicoes(event:PaginableEvent):void
		{
			TrafegusWS.getIntance().solicitaHistoricoPosicoes(this.solicitaHistoricoPosicoesHandler,this.view.param,event.paginaAtual);
		}
		public function atualizaHistoricoPosicoes():void
		{
			TrafegusWS.getIntance().solicitaHistoricoPosicoes(this.solicitaHistoricoPosicoesHandler,this.view.param,0);
		}
		private function solicitaHistoricoPosicoesHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().historicoPosicoesVeiculosArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var dataPos:HistoricoPosicoesVeiculoVO = new HistoricoPosicoesVeiculoVO(obj);
				MainModel.getInstance().historicoPosicoesVeiculosArray.addItem(dataPos);
			}
			this.view.dispatchEvent(new VehiclesHistoricEvent(VehiclesHistoricEvent.ROUTE_RECEIVED_EVENT,true));
		}
		public function solicitaTotalHistoricoPosicoes():void
		{
			TrafegusWS.getIntance().solicitaTotalHistoricoPosicoes(solicitaTotalHistoricoPosicoesResultHandler,this.view.param);
		}
		private function solicitaTotalHistoricoPosicoesResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalHistoricoPosicoes = int(obj.total.toString());
			}
		}
		public function advancedSearchEventRandler(event:AdvancedSearchEvent):void
		{
			var advancedSearchHistoricoImpl:AdvancedSearchHistoricoImpl = new AdvancedSearchHistoricoImpl();
			advancedSearchHistoricoImpl.addEventListener(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,advancedSearchHistoricoEventHandler);
			MyPopUpManager.addPopUp(advancedSearchHistoricoImpl,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(advancedSearchHistoricoImpl);
		}
		private function advancedSearchHistoricoEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getIntance().procuraHistoricoPosicoes(procuraHistoricoPosicoesResultHandler,this.view.param.vehiclePlate,AdvancedSearchHistoricoVO(event.genericVO));
		}
		private function procuraHistoricoPosicoesResultHandler(event:ResultEvent):void
		{
			
		}
	}
}