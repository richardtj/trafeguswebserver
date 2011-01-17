package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.model.ReferenciaZoomModel;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ClassesReferenciaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import mx.collections.ArrayCollection;
	import mx.managers.PopUpManager;

	public class ReferenciaZoomController extends BaseZoomController
	{
		public var model:ReferenciaZoomModel;
		public function ReferenciaZoomController()
		{
		}
		public function atualizaReferenciasZoom():void
		{
			
		}
		public function referenciaSelecionada():void
		{
			if(ReferenciaZoom(this.view).list.selectedItem != null)
			{
				var event:ReferenciaSelecionadaEvent = new ReferenciaSelecionadaEvent(ReferenciaSelecionadaEvent.REFERENCIA_SELECIONADA_EVENT,ReferenciaVO(ReferenciaZoom(this.view).list.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma referência selecionada.");
			}
		}
		public function referenciasFilterFunction(item:Object):Boolean
		{
			return (String(ReferenciaVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(item).refeDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaReferenciasZoom(event:PaginableEvent):void
		{
			MainModel.getInstance().referenciasZoom = new ArrayCollection(MainModel.getInstance().referencias.source.slice(event.paginaAtual,event.paginaAtual+20));
			MainModel.getInstance().referenciasZoom.filterFunction = this.referenciasFilterFunction;
		}
	}
}