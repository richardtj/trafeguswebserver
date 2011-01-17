package br.com.chapecosolucoes.trafegusweb.client.components.searchInput
{
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	
	import flash.events.FocusEvent;
	import flash.events.MouseEvent;
	
	import mx.controls.Image;
	import mx.controls.TextInput;

	[Event(name="advancedSearchEvent", type="br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent")]
	public class SearchInputFXBase extends TextInput
	{
		[Embed(source='assets/search.png')]
		private var _searchIcon:Class;
		private var _searchImg:Image;
		private var _textEmpty:Boolean;
		private var _currentlyFocused:Boolean = false;


		public function SearchInputFXBase()
		{
			super();
			_textEmpty = true;
			
			this._prompt = "Digite a informação que deseja procurar"

			addEventListener(Event.CHANGE, handleChange);
			addEventListener(FocusEvent.FOCUS_IN, handleFocusIn);
			addEventListener(FocusEvent.FOCUS_OUT, handleFocusOut);
		}

		private var _prompt:String = "";

		public function get prompt():String
		{
			return _prompt;
		}

		[Bindable]
		public function set prompt(value:String):void
		{
			_prompt = value;

			invalidateProperties();
			invalidateDisplayList();
		}

		private var _promptFormat:String = '<font color="#999999"><i>[prompt]</i></font>';

		public function get promptFormat():String
		{
			return _promptFormat;
		}

		public function set promptFormat(value:String):void
		{
			_promptFormat = value;
			if (_promptFormat.indexOf("[prompt]") < 0)
			{
			}
			invalidateDisplayList();
		}

		[Bindable("textChanged")]
		[CollapseWhiteSpace]
		[NonCommittingChangeEvent("change")]

		override public function set text(value:String):void
		{
			_textEmpty = (!value) || value.length == 0;
			super.text = value;
			invalidateDisplayList();
		}

		override public function get text():String
		{
			if (_textEmpty)
			{
				return "";
			}
			else
			{
				return super.text;
			}
		}
		private var _displayAsPassword:Boolean = false;

		override public function set displayAsPassword(value:Boolean):void
		{
			_displayAsPassword = value;
			super.displayAsPassword = value;
		}

		override public function get displayAsPassword():Boolean
		{
			return _displayAsPassword;
		}

		override protected function createChildren():void
		{
			super.createChildren();
			_searchImg = new Image();
			_searchImg.addEventListener(MouseEvent.CLICK,clickHandler);
			_searchImg.useHandCursor = true;
			_searchImg.buttonMode = true;
			_searchImg.source = _searchIcon;
			_searchImg.width = 15;
			_searchImg.height = 15;
			_searchImg.x = 2;
			_searchImg.y = 3;

			setStyle("paddingLeft", _searchImg.width + 2);
			addChild(_searchImg);

		}
		private function clickHandler(e:MouseEvent):void
		{
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT);
			this.dispatchEvent(event);
		}

		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
			if (_textEmpty && _prompt != "" && !_currentlyFocused)
			{
				if (_promptFormat == "")
				{
					super.text = _prompt;
				}
				else
				{
					super.htmlText = _promptFormat.replace(/\[prompt\]/g, _prompt);
				}

				if (super.displayAsPassword)
				{
					var oldVal:Boolean = _displayAsPassword;
					super.displayAsPassword = false;
					_displayAsPassword = oldVal;
				}
			}
			else
			{
				if (super.displayAsPassword != _displayAsPassword)
				{
					super.displayAsPassword = _displayAsPassword;
				}
			}

			super.updateDisplayList(unscaledWidth, unscaledHeight);
		}

		protected function handleChange(event:Event):void
		{
			_textEmpty = super.text.length == 0;
		}

		protected function handleFocusIn(event:FocusEvent):void
		{
			_currentlyFocused = true;
			if (_textEmpty)
			{
				super.htmlText = "";
				validateNow();
			}
		}

		protected function handleFocusOut(event:FocusEvent):void
		{
			_currentlyFocused = false;

			invalidateDisplayList();
		}
	}
}

