package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.CidaCidadeZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.CidaCidadeSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.CidaCidadeVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class CidaCidadeZoomController extends BaseZoomController
	{
		public function CidaCidadeZoomController()
		{
			super();
		}
		public function advancedSearchEventHandler():void
		{
			
		}
		public function inicializaListaCidaCidade():void
		{
			if(MainModel.getInstance().cidaCidadeArray.length == 0)
			{
				this.atualizaListaCidaCidade()
			}
		}
		public function atualizaListaCidaCidade():void
		{
			TrafegusWS.getInstance().solicitaTotalListaCidaCidade(solicitaTotalListaCidaCidadeResultHandler);
		}
		private function solicitaTotalListaCidaCidadeResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaCidaCidade = int(obj.total.toString());
			}
			TrafegusWS.getInstance().solicitaListaCidaCidade(solicitaListaCidaCidadeResultHandler,0);
		}
		public function cidaCidadeSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:CidaCidadeSelecionadaEvent = new CidaCidadeSelecionadaEvent(CidaCidadeSelecionadaEvent.CIDA_CIDADE_SELECIONADA_EVENT,CidaCidadeVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao(CidaCidadeZoom.NENHUMA_CIDADE_SELECIONADA);
			}
		}
		public function solicitaListaCidaCidade(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaCidaCidade(solicitaListaCidaCidadeResultHandler,event.paginaAtual);
		}
		private function solicitaListaCidaCidadeResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().cidaCidadeArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var cidaCidadeVO:CidaCidadeVO = new CidaCidadeVO();
				cidaCidadeVO.setCidaCidadeVO(obj);
				cidaCidadeVO.count = i++;
				MainModel.getInstance().cidaCidadeArray.addItem(cidaCidadeVO);
			}
		}
		public function cidaCidadeFilterFunction(item:Object):Boolean
		{
			return (String(CidaCidadeVO(item).cidaCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(CidaCidadeVO(item).cidaDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(CidaCidadeVO(item).cidaEsta.estaDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(CidaCidadeVO(item).cidaEsta.estaPais.paisDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().cidaCidadeArray.removeAll();
			}
			super.closeHandler();
		}
	}
}