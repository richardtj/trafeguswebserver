package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoParadaSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TipoParadaVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class TipoParadaZoomController extends BaseZoomController
	{
		public function TipoParadaZoomController()
		{
			super();
		}
		public function tipoParadaFilterFunction(item:Object):Boolean
		{
			return (String(TipoParadaVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TipoParadaVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaTotalListaTipoParada():void
		{
			TrafegusWS.getInstance().solicitaTotalListaTipoParada(solicitaTotalListaTipoParadaResultHandler);
		}
		private function solicitaTotalListaTipoParadaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaTipoParada = int(obj.total.toString());
			}
		}
		public function atualizaListaTipoParada():void
		{
			this.view.paginable.paginaAtual=1;
			this.solicitaTotalListaTipoParada();
			TrafegusWS.getInstance().solicitaListaTipoParada(solicitaListaTipoParadaResultEvent,0);
		}
		public function tipoParadaSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:TipoParadaSelecionadoEvent = new TipoParadaSelecionadoEvent(TipoParadaSelecionadoEvent.TIPO_PARADA_SELECIONADO_EVENT,TipoParadaVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum tipo de parada selecionado.");
			}
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().tipoParadaArray.removeAll();
			}
			super.closeHandler();
		}
		public function solicitaListaTipoParada(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaTipoParada(solicitaListaTipoParadaResultEvent,event.paginaAtual);
		}
		private function solicitaListaTipoParadaResultEvent(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().tipoParadaArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var tipoParada:TipoParadaVO = new TipoParadaVO();
				tipoParada.setTipoParadaVO(obj);
				tipoParada.count = i++;
				MainModel.getInstance().tipoParadaArray.addItem(tipoParada);
			}
		}
		public function advancedSearchTipoParadaEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraTipoParada(procuraTipoParadaResultHandler,event.genericVO);
		}
		private function procuraTipoParadaResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaTipoParada = 1;
			this.solicitaListaTipoParadaResultEvent(event);
		}
	}
}