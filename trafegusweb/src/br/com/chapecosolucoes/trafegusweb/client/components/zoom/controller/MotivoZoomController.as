package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.MotivoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.MotivoSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.MotiMotivoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.rpc.events.ResultEvent;

	public class MotivoZoomController extends BaseZoomController
	{
		public function MotivoZoomController()
		{
			super();
		}
		public function advancedSearchMotivosEventHandler(event:AdvancedSearchEvent):void
		{
			
		}
		public function inicializaListaMotivos():void
		{
			if(MainModel.getInstance().motivosArray.length == 0)
			{
				this.atualizaListaMotivos();
			}
		}
		public function atualizaListaMotivos():void
		{
			TrafegusWS.getInstance().solicitaListaMotivos(solicitaListaMotivosResultHandler);
		}
		public function solicitaTotalListaMotivos():void{
			TrafegusWS.getInstance().solicitaTotalListaMotivos(solicitaTotalListaMotivosResultHandler);
		}
		private function solicitaTotalListaMotivosResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaMotivos = int(obj.total.toString());
			}
		}
		private function solicitaListaMotivosResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().motivosArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var motivo:MotiMotivoVO = new MotiMotivoVO();
				motivo.setMotivoVO(obj);
				motivo.count = i++;
				MainModel.getInstance().motivosArray.addItem(motivo);
			}
			this.solicitaTotalListaMotivos();
		}
		public function solicitaListaMotivos(event:PaginableEvent):void
		{
			
		}
		public function motivoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var event:MotivoSelecionadoEvent = new MotivoSelecionadoEvent(MotivoSelecionadoEvent.MOTIVO_SELECIONADO_EVENT,MotiMotivoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao(MotivoZoom.NENHUM_MOTIVO_SELECIONADO);
			}
		}
		public function motivosFilterFunction(item:Object):Boolean
		{
			return (String(MotiMotivoVO(item).motiCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MotiMotivoVO(item).motiDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MotiMotivoVO(item).motiTmotCodigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(MotiMotivoVO(item).tmotDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		override public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().motivosArray.removeAll();
			}
			super.closeHandler();
		}
	}
}