package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.MvecModeloVeiculoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ZoomCodDetailEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.MvecModeloVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class MvecModeloVeiculoZoomController extends BaseZoomController
	{
		public function MvecModeloVeiculoZoomController()
		{
			super();
		}
		public function atualizaListaMvecModeloVeiculo():void
		{
			TrafegusWS.getInstance().solicitaTotalListaMvecModeloVeiculo(solicitaTotalListaMvecModeloVeiculoResultHandler);
		}
		private function solicitaListaMvecModeloVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().mvecModeloVeiculoArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var mvecModeloVeiculoVO:MvecModeloVeiculoVO = new MvecModeloVeiculoVO();
				mvecModeloVeiculoVO.setMvecModeloVeiculoVO(obj);
				mvecModeloVeiculoVO.count = i++;
				MainModel.getInstance().mvecModeloVeiculoArray.addItem(mvecModeloVeiculoVO);
			}
		}
		private function solicitaTotalListaMvecModeloVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaMvecModeloVeiculo = int(obj.total.toString());
			}
			TrafegusWS.getInstance().solicitaListaMvecModeloVeiculo(solicitaListaMvecModeloVeiculoResultHandler,0);
		}
		public function advancedSearchClickEventHandler(event:AdvancedSearchEvent):void
		{
			
		}
		public function mvecModeloVeiculoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:MvecModeloVeiculoSelecionadoEvent = new MvecModeloVeiculoSelecionadoEvent(MvecModeloVeiculoSelecionadoEvent.MVEC_MODELO_VEICULO_SELECIONADO_EVENT,MvecModeloVeiculoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum modelo de veiculo selecionado");
			}
		}
		public function mvecModeloVeiculoFilterFunction(item:Object):Boolean
		{
			return (String(MvecModeloVeiculoVO(item).mvecCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MvecModeloVeiculoVO(item).mvecDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MvecModeloVeiculoVO(item).mvecMvei.mveiCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MvecModeloVeiculoVO(item).mvecMvei.mveiDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MvecModeloVeiculoVO(item).mvecImportado).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MvecModeloVeiculoVO(item).mvecCodigoGr).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaMvecModeloVeiculo(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaMvecModeloVeiculo(solicitaListaMvecModeloVeiculoResultHandler,event.paginaAtual);
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().mvecModeloVeiculoArray.removeAll();
			}
			super.closeHandler();
		}
	}
}