package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoLocaisEventosSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TipoLocaisEventosVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class TipoLocaisEventosZoomController extends BaseZoomController
	{
		public function TipoLocaisEventosZoomController()
		{
			super();
		}
		public function tipoLocaisEventosFilterFunction(item:Object):Boolean
		{
			return (String(TipoLocaisEventosVO(item).tlevCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TipoLocaisEventosVO(item).tlevDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TipoLocaisEventosVO(item).tlevSequencia).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function atualizaListaTipoLocaisEventos():void
		{
			TrafegusWS.getInstance().solicitaTotalListaTipoLocaisEventos(this.solicitaTotalListaTipoLocaisEventosResultHandler);
			TrafegusWS.getInstance().solicitaListaTipoLocaisEventos(this.solicitaListaTipoLocaisEventosResultHandler);
		}
		private function solicitaTotalListaTipoLocaisEventosResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaTipoLocaisEventos = int(obj.total.toString());
			}
		}
		public function solicitaListaTipoLocaisEventos(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaTipoLocaisEventos(this.solicitaListaTipoLocaisEventosResultHandler);
		}
		public function tipoLocaisEventosSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var tipoLocaisEventosSelecionadoEvent:TipoLocaisEventosSelecionadoEvent = new TipoLocaisEventosSelecionadoEvent(TipoLocaisEventosSelecionadoEvent.TIPO_LOCAIS_EVENTOS_SELECIONADO_EVENT,TipoLocaisEventosVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(tipoLocaisEventosSelecionadoEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum tipo locais eventos selecionado.");
			}
		}
		public function advancedSearchLocaisEventosEventHandler(event:AdvancedSearchEvent):void
		{
			
		}
		private function solicitaListaTipoLocaisEventosResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().tipoLocaisEventosArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var tipoLocaisEventos:TipoLocaisEventosVO = new TipoLocaisEventosVO();
				tipoLocaisEventos.setTipoLocaisEventosVO(obj);
				tipoLocaisEventos.count = i++;
				MainModel.getInstance().tipoLocaisEventosArray.addItem(tipoLocaisEventos);
			}
		}	
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().tipoLocaisEventosArray.removeAll();
			}
			super.closeHandler();
		}
	}
}