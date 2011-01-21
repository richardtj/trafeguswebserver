package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearchReferenciasImpl;
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.model.ReferenciaZoomModel;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ClassesReferenciaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.core.FlexGlobals;
	import mx.core.IFlexDisplayObject;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class ReferenciaZoomController extends BaseZoomController
	{
		public var model:ReferenciaZoomModel;
		public function ReferenciaZoomController()
		{
		}
		public function atualizaReferenciasZoom():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalRefencias();
			TrafegusWS.getIntance().solicitaRefenciasZoom(solicitaReferenciasZoomResultHandler,0);
		}
		public function solicitaTotalRefencias():void
		{
			TrafegusWS.getIntance().solicitaTotalRefencias(solicitaTotalRefenciasResultHandler);
		}
		private function solicitaTotalRefenciasResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalReferenciasZoom = int(obj.total.toString());
			}
		}
		private function solicitaReferenciasZoomResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().referenciasZoom.removeAll();
			for each (var obj:Object in resultArray)
			{
				var referenciaVO:ReferenciaVO = new ReferenciaVO();
				referenciaVO.setReferenciaVO(obj);
				MainModel.getInstance().referenciasZoom.addItem(referenciaVO);
			}
		}
		public function referenciaSelecionada():void
		{
			if(ReferenciaZoom(this.view).list.selectedItem != null)
			{
				var event:ReferenciaSelecionadaEvent = new ReferenciaSelecionadaEvent(ReferenciaSelecionadaEvent.REFERENCIA_SELECIONADA_EVENT,ReferenciaVO(ReferenciaZoom(this.view).list.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma referência selecionada.");
			}
		}
		public function referenciasFilterFunction(item:Object):Boolean
		{
			return (String(ReferenciaVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(item).refeDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaReferenciasZoom(event:PaginableEvent):void
		{
			TrafegusWS.getIntance().solicitaRefenciasZoom(solicitaReferenciasZoomResultHandler,event.paginaAtual);
		}
		public function advancedSearchClickEventHandler(event:AdvancedSearchEvent):void
		{
			var advancedSearchReferencias:AdvancedSearchReferenciasImpl = new AdvancedSearchReferenciasImpl();
			advancedSearchReferencias.addEventListener(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,advancedSearchEventHandler);
			MyPopUpManager.addPopUp(advancedSearchReferencias,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(advancedSearchReferencias);
		}
		private function advancedSearchEventHandler(event:AdvancedSearchEvent):void
		{
			var referenciaVO:ReferenciaVO = ReferenciaVO(event.genericVO);
			TrafegusWS.getIntance().procuraRefenciasZoom(procuraRefenciasZoomResultHandler,referenciaVO);
		}
		private function procuraRefenciasZoomResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalReferenciasZoom = MainModel.getInstance().itensPorPagina;
			this.solicitaReferenciasZoomResultHandler(event);
		}
	}
}