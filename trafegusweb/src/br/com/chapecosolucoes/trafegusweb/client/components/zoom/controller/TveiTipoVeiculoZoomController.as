package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TveiTipoVeiculoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TveiTipoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class TveiTipoVeiculoZoomController extends BaseZoomController
	{
		public function TveiTipoVeiculoZoomController()
		{
			super();
		}
		public function solicitaListaTveiTipoVeiculo(event:PaginableEvent):void
		{
			
		}
		public function atualizaListaTveiTipoVeiculo():void
		{
			TrafegusWS.getInstance().solicitaTotalListaTveiTipoVeiculo(solicitaTotalListaTveiTipoVeiculoResultHandler);
			TrafegusWS.getInstance().solicitaListaTveiTipoVeiculo(solicitaListaTveiTipoVeiculoResultHandler);
		}
		private function solicitaListaTveiTipoVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().tveiTipoVeiculoArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var tveiTipoVeiculo:TveiTipoVeiculoVO = new TveiTipoVeiculoVO();
				tveiTipoVeiculo.setTveiTipoVeiculoVO(obj);
				tveiTipoVeiculo.count = i++;
				MainModel.getInstance().tveiTipoVeiculoArray.addItem(tveiTipoVeiculo);
			}
		}
		private function solicitaTotalListaTveiTipoVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaTveiTipoVeiculo = int(obj.total.toString());
			}
		}
		public function advancedSearchClickEventHandler():void
		{
			
		}
		public function tveiTipoVeiculoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:TveiTipoVeiculoSelecionadoEvent = new TveiTipoVeiculoSelecionadoEvent(TveiTipoVeiculoSelecionadoEvent.TVEI_TIPO_VEICULO_SELECIONADO_EVENT,TveiTipoVeiculoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum tipo de veiculo selecionado.");
			}
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().tveiTipoVeiculoArray.removeAll();
			}
			super.closeHandler();
		}
	}
}