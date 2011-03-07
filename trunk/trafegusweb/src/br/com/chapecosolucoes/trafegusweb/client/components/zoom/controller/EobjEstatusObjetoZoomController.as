package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.EobjEstatusObjetoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.EobjEstatusObjetoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class EobjEstatusObjetoZoomController extends BaseZoomController
	{
		public function EobjEstatusObjetoZoomController()
		{
			super();
		}
		public function atualizaListaEobjEstatusObjetoZoom():void
		{
			TrafegusWS.getInstance().solicitaListaEobjEstatusObjeto(solicitaListaEobjEstatusObjetoResultHandler);
		}
		private function solicitaListaEobjEstatusObjetoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().carretasDisponiveisArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var eobjEstatusObjetoVO:EobjEstatusObjetoVO = new EobjEstatusObjetoVO();
				eobjEstatusObjetoVO.setEobjEstatusObjetoVO(obj);
				eobjEstatusObjetoVO.count = i++;
				MainModel.getInstance().eobjEstatusObjetoArray.addItem(eobjEstatusObjetoVO);
			}
		}
		public function advancedSearchClickEventHandler():void
		{
			
		}
		public function eobjEstatusObjetoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:EobjEstatusObjetoSelecionadoEvent = new EobjEstatusObjetoSelecionadoEvent(EobjEstatusObjetoSelecionadoEvent.EOBJ_ESTATUS_OBJETO_SELECIONADO_EVENT,EobjEstatusObjetoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum estatus objeto selecionado.");
			}
		}
		public function solicitaListaEobjEstatusObjetoZoom(event:PaginableEvent):void
		{
			
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().eobjEstatusObjetoArray.removeAll();
			}
			super.closeHandler();
		}
	}
}