/**
 * TextToSpeechController.java
 *TODO	
 */
package com.ibm.texttospeech.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

/**
 * @author Yu Tao Wang
 *
 */
@Controller
@RequestMapping("texttospeech")
public class TextToSpeechController
{
	// private static TextToSpeech speechService = new
	// TextToSpeech("3f90d2c6-bc1a-4380-9cce-6a380579193b", "LAv07ainS3RH");

	@RequestMapping("/export.do")
	public void exportSpeech(String text, HttpServletResponse response)
	{
		TextToSpeech speechService = new TextToSpeech(
				"3f90d2c6-bc1a-4380-9cce-6a380579193b", "LAv07ainS3RH");

		try
		{

			if (StringUtils.isEmpty(text))
			{
				response.getWriter().print("text 参数不能为空");
			} else
			{
				InputStream stream = speechService.synthesize(text,
						Voice.EN_ALLISON, new AudioFormat("audio/wav"))
						.execute();

				InputStream in = WaveUtils.reWriteWaveHeader(stream);
				// OutputStream out = new FileOutputStream("hello_world2.wav");
				OutputStream export = response.getOutputStream();

				if (StringUtils.isNotEmpty(text) && text.length() > 20)
				{
					text = text.substring(0, 20);
					response.setHeader("Content-Disposition",
							"attachment; filename=\"" + text + ".wav" + "\"");
				}
				response.addHeader("Content-Length", "" + in.available());
				response.setContentType(
						"application/octet-stream;charset=UTF-8");

				byte[] buffer = new byte[1024];

				int length;
				int count = 1;
				while ((length = in.read(buffer)) > 0)
				{
					export.write(buffer, 0, length);
					count++;
				}
				int dataLength = length * count;

				export.flush();
				export.close();
				in.close();
				stream.close();
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
