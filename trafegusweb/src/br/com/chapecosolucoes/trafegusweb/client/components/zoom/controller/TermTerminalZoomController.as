package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TermTerminalSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class TermTerminalZoomController extends BaseZoomController
	{
		public function TermTerminalZoomController()
		{
			super();
		}
		public function atualizaListaTermTerminal():void
		{
			this.solicitaTotalListaTermTerminal();
			TrafegusWS.getInstance().solicitaListaTermTerminaisDisponiveis(solicitaListaTermTerminaisDisponiveisResultHandler,0);
		}
		public function advancedSearchEventHandler(event:AdvancedSearchEvent):void
		{
			
		}
		public function termTerminalSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:TermTerminalSelecionadoEvent = new TermTerminalSelecionadoEvent(TermTerminalSelecionadoEvent.TERM_TERMINAL_SELECIONADO_EVENT,TerminalVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum terminal selecionado.");
			}
		}
		public function solicitaTotalListaTermTerminal():void
		{
			TrafegusWS.getInstance().solicitaTotalListaTermTerminaisDisponiveis(solicitaTotalListaTermTerminaisDisponiveisResultHandler);
		}
		private function solicitaTotalListaTermTerminaisDisponiveisResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaTermTerminal = int(obj.total.toString());
			}
		}
		public function solicitaListaTermTerminal(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaTermTerminaisDisponiveis(solicitaListaTermTerminaisDisponiveisResultHandler,event.paginaAtual);
		}
		private function solicitaListaTermTerminaisDisponiveisResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().termTerminalArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var terminalVO:TerminalVO = new TerminalVO();
				terminalVO.setTerminalVO(obj);
				terminalVO.count = i++;
				MainModel.getInstance().termTerminalArray.addItem(terminalVO);
			}
		}
	}
}