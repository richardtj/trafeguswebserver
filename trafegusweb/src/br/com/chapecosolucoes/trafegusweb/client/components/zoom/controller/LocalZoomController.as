package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.LocaisZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.PaginableEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.LocalDetailsView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import com.google.maps.LatLng;
	
	import flash.events.MouseEvent;
	import flash.net.registerClassAlias;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;

	public class LocalZoomController
	{
		public function LocalZoomController()
		{
		}
		public var view:LocaisZoom;
		public function locaisFilterFunction(item:Object):Boolean
		{
			return (String(LocalVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).codigoGrupo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).descricaoGrupo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).gpsLatitudeString).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(LocalVO(item).gpsLongitudeString).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaLocais(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaLocais(solicitaListaLocaisResultEvent,event.paginaAtual);
		}
		public function inicializaListaLocais():void
		{
			if(MainModel.getInstance().locaisArray.length == 0)
			{
				this.atualizaListaLocais();
			}
		}
		public function atualizaListaLocais():void
		{
			this.view.paginable.paginaAtual=1;
			this.solicitaTotalListaLocais();
			TrafegusWS.getInstance().solicitaListaLocais(solicitaListaLocaisResultEvent,0);
		}
		private function solicitaListaLocaisResultEvent(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().locaisArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var local:LocalVO = new LocalVO();
				local.setLocalVO(obj);
				local.count = i++
				MainModel.getInstance().locaisArray.addItem(local);
			}
		}
		public function localSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				registerClassAlias("br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO",br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO);
				var localEvent:SelectedLocalEvent = new SelectedLocalEvent(SelectedLocalEvent.SELECTED_LOCAL_EVENT,LocalVO(ObjectUtil.clone(this.view.grid.selectedItem)));
				this.view.dispatchEvent(localEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum local selecionado.");
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().locaisArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaLocais():void
		{
			TrafegusWS.getInstance().solicitaTotalListaLocais(solicitaTotalListaLocaisResultHandler);
		}
		private function solicitaTotalListaLocaisResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaLocais = int(obj.total.toString());
			}
		}
		public function localSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			event.stopImmediatePropagation();
			this.localSelecionado();
		}
		public function mouseOverEventHandler():void
		{
			LocalDetailsView.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchLocaisEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraLocais(procuraLocaisResultHandler,event.genericVO);
		}
		private function procuraLocaisResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaLocais = 1;
			this.solicitaListaLocaisResultEvent(event);
		}
	}
}