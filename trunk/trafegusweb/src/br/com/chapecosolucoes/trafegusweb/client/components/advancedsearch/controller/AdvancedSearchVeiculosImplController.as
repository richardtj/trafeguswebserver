package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearchVeiculosImpl;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	
	import flash.display.DisplayObject;
	
	import mx.containers.Form;
	import mx.containers.FormItem;
	import mx.controls.Alert;
	import mx.controls.TextInput;
	import mx.core.IFlexDisplayObject;

	public class AdvancedSearchVeiculosImplController extends AdvancedSearchController
	{
		public function AdvancedSearchVeiculosImplController()
		{
			super();
		}
		override public function search():void
		{
			var formItemPlaca:FormItem = FormItem(Form(this.view.form).getChildByName("formItemPlaca"));
			var formItemDesc:FormItem = FormItem(Form(this.view.form).getChildByName("formItemDesc"));
			var veiculoVO:PosicaoVeiculoVO = new PosicaoVeiculoVO();
			veiculoVO.vehiclePlate = TextInput(formItemPlaca.getChildByName("textInputPlaca")).text;
			veiculoVO.gpsDescSis = TextInput(formItemDesc.getChildByName("textInputDesc")).text;
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,veiculoVO);
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}