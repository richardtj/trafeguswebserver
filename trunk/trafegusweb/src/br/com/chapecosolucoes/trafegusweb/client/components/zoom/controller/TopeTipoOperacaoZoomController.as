package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TopeTipoOperacaoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TopeTipoOperacaoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class TopeTipoOperacaoZoomController extends BaseZoomController
	{
		public function TopeTipoOperacaoZoomController()
		{
			super();
		}
		public function atualizaListaTopeTipoOperacao():void
		{
			TrafegusWS.getInstance().solicitaTotalListaTopeTipoOperacao(solicitaTotalListaTopeTipoOperacaoResultHandler);
		}
		private function solicitaTotalListaTopeTipoOperacaoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaTopeTipoOperacao = int(obj.total.toString());
			}
			TrafegusWS.getInstance().solicitaListaTopeTipoOperacao(solicitaListaTopeTipoOperacaoResultHandler,0);
		}
		private function solicitaListaTopeTipoOperacaoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().topeTipoOperacaoArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var topeTipoOperacaoVO:TopeTipoOperacaoVO = new TopeTipoOperacaoVO();
				topeTipoOperacaoVO.setTopeTipoOperacaoVO(obj);
				topeTipoOperacaoVO.count = i++;
				MainModel.getInstance().topeTipoOperacaoArray.addItem(topeTipoOperacaoVO);
			}
		}
		public function advancedSearchEventHandler(event:AdvancedSearchEvent):void
		{
			
		}
		public function topeTipoOperacaoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:TopeTipoOperacaoSelecionadoEvent = new TopeTipoOperacaoSelecionadoEvent(TopeTipoOperacaoSelecionadoEvent.TOPE_TIPO_OPERACAO_SELECIONADO_EVENT,TopeTipoOperacaoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum tipo de operação selecionado.");
			}
		}
		public function solicitaListaTopeTipoOperacao(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaTopeTipoOperacao(solicitaListaTopeTipoOperacaoResultHandler,event.paginaAtual);
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().topeTipoOperacaoArray.removeAll();
			}
			super.closeHandler();
		}
	}
}