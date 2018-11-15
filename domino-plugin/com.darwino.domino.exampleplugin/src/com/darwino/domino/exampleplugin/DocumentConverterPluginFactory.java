package com.darwino.domino.exampleplugin;

import java.util.Arrays;
import java.util.Collection;

import com.darwino.domino.jstore.converters.ext.DocumentConverterPlugin;
import com.darwino.domino.jstore.converters.ext.IDocumentConverterPluginFactory;

public class DocumentConverterPluginFactory implements IDocumentConverterPluginFactory {

	@Override
	public Collection<DocumentConverterPlugin> getDocumentConverterPlugins() {
		return Arrays.asList(
			(DocumentConverterPlugin)new ExampleConverterPlugin()
		);
	}

}
