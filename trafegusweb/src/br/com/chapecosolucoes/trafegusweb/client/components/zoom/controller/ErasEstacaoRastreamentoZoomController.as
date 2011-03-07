package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ErasEstacaoRastreamentoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.ErasEstacaoRastreamentoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ErasEstacaoRastreamentoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class ErasEstacaoRastreamentoZoomController extends BaseZoomController
	{
		public function ErasEstacaoRastreamentoZoomController()
		{
			super();
		}
		public function erasEstacaoRastreamentoFilterFunction(item:Object):Boolean
		{
			return (String(ErasEstacaoRastreamentoVO(item).erasCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ErasEstacaoRastreamentoVO(item).erasDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ErasEstacaoRastreamentoVO(item).erasGrisPjurPessOras.pjurRazaoSocial).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ErasEstacaoRastreamentoVO(item).erasSras.srasDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function inicializaListaErasEstacaoRastreamento():void
		{
			if(MainModel.getInstance().erasEstacaoRastreamentoArray.length == 0)
			{
				this.atualizaListaErasEstacaoRastreamento();
			}
		}
		public function advancedSearchEventHandler():void
		{
			
		}
		public function atualizaListaErasEstacaoRastreamento():void
		{
			TrafegusWS.getInstance().solicitaTotalListaErasEstacaoRastreamento(solicitaTotalListaErasEstacaoRastreamentoResultHandler);
		}
		private function solicitaTotalListaErasEstacaoRastreamentoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event)
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaErasEstacaoRastreamento = int(obj.total.toString());
			}
			TrafegusWS.getInstance().solicitaListaErasEstacaoRastreamento(solicitaListaErasEstacaoRastreamentoResultHandler,0);
		}
		private function solicitaListaErasEstacaoRastreamentoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().erasEstacaoRastreamentoArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var erasEstacaoRastreamentoVO:ErasEstacaoRastreamentoVO = new ErasEstacaoRastreamentoVO();
				erasEstacaoRastreamentoVO.setErasEstacaoRastreamentoVO(obj);
				erasEstacaoRastreamentoVO.count = i++
				MainModel.getInstance().erasEstacaoRastreamentoArray.addItem(erasEstacaoRastreamentoVO);
			}
		}
		public function erasEstacaoRastreamentoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:ErasEstacaoRastreamentoSelecionadaEvent = new ErasEstacaoRastreamentoSelecionadaEvent(ErasEstacaoRastreamentoSelecionadaEvent.ERAS_ESTACAO_RASTREAMENTO_SELECIONADA_EVENT,ErasEstacaoRastreamentoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao(ErasEstacaoRastreamentoZoom.NENHUMA_ESTACAO_RASTREAMENTO_SELECIONADA);
			}
		}
		public function solicitaListaErasEstacaoRastreamento(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaErasEstacaoRastreamento(solicitaListaErasEstacaoRastreamentoResultHandler,event.paginaAtual);
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().erasEstacaoRastreamentoArray.removeAll();
			}
			super.closeHandler();
		}
	}
}