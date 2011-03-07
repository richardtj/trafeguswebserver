package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PessPessoaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PessPessoaVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class PessPessoaZoomController extends BaseZoomController
	{
		public function PessPessoaZoomController()
		{
			super();
		}
		public function atualizaListaPessPessoas():void
		{
			TrafegusWS.getInstance().solicitaTotalListaPessPessoa(solicitaTotalListaPessPessoaResultHandler);
		}
		private function solicitaTotalListaPessPessoaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaPessPessoa = int(obj.total.toString());
			}
			TrafegusWS.getInstance().solicitaListaPessPessoa(solicitaListaPessPessoaResultHandler,0);
		}
		public function advancedSearchEventHandler():void
		{
			
		}
		public function pessPessoaSelecionada():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:PessPessoaSelecionadaEvent = new PessPessoaSelecionadaEvent(PessPessoaSelecionadaEvent.PESS_PESSOA_SELECIONADA_EVENT,PessPessoaVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma pessoa selecionada.");
			}
		}
		public function solicitaListaPessPessoas(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaPessPessoa(solicitaListaPessPessoaResultHandler,event.paginaAtual);
		}
		private function solicitaListaPessPessoaResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().pessPessoaArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var pessPessoaVO:PessPessoaVO = new PessPessoaVO();
				pessPessoaVO.setPessPessoaVO(obj);
				pessPessoaVO.count = i++;
				MainModel.getInstance().pessPessoaArray.addItem(pessPessoaVO);
			}
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().pessPessoaArray.removeAll();
			}
			super.closeHandler();
		}
	}
}