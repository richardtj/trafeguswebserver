package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.RotaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedRouteEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.RouteDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import com.google.maps.services.Route;
	
	import flash.events.MouseEvent;
	import flash.net.registerClassAlias;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;

	public class RotaZoomController
	{
		public function RotaZoomController()
		{
		}
		public var view:RotaZoom;
		public function rotaFilterFunction(item:Object):Boolean
		{
			return (String(RouteVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(RouteVO(item).coordenada).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(RouteVO(item).coordenadasPipe).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(RouteVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(RouteVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(RouteVO(item).distancia).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function rotaSelecionada():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var rota:RouteVO = RouteVO(this.view.grid.selectedItem);
				registerClassAlias("br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO",br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO);
				registerClassAlias("br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO",br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO);
				var routeEvent:SelectedRouteEvent = new SelectedRouteEvent(SelectedRouteEvent.SELECTED_ROUTE_EVENT,RouteVO(ObjectUtil.clone(rota)));
				this.view.dispatchEvent(routeEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma rota selecionada.");
			}
		}
		public function solicitaListaRotas(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaRotas(solicitaListaRotasResultHandler,event.paginaAtual);
		}
		public function atualizaListaRotas():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalListaRotas();
			TrafegusWS.getInstance().solicitaListaRotas(solicitaListaRotasResultHandler,0);
		}
		private function solicitaListaRotasResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().rotasArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var route:RouteVO = new RouteVO();
				route.setRouteVO(obj);
				route.count = i++;
				MainModel.getInstance().rotasArray.addItem(route);
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().rotasArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaRotas():void
		{
			TrafegusWS.getInstance().solicitaTotalListaRotas(solicitaTotalListaRotasResultHandler);
		}
		private function solicitaTotalListaRotasResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaRotas = int(obj.total.toString());
			}
		}
		public function selectedRouteEventHandler(event:SelectedRouteEvent):void
		{
			event.stopImmediatePropagation();
			this.rotaSelecionada();
		}
		public function mouseOverEventHandler():void
		{
			RouteDetails.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchRotasEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraRotas(procuraRotasResultHandler,event.genericVO);
		}
		private function procuraRotasResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaRotas = 1;
			this.solicitaListaRotasResultHandler(event);
		}
	}
}