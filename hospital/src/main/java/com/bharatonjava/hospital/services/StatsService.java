package com.bharatonjava.hospital.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IPatientDao;
import com.bharatonjava.hospital.dao.IStatsDao;
import com.bharatonjava.hospital.domain.VisitStats;

@Service
public class StatsService {

	private static final Logger log = LoggerFactory.getLogger(StatsService.class);
	
	private IPatientDao patientDao;
	private IStatsDao statsDao;

	public StatsService() {
	}

	@Autowired
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@Autowired
	public void setStatsDao(IStatsDao statsDao) {
		this.statsDao = statsDao;
	}

	@Transactional
	public List<VisitStats> getPatientVisitTrend() {
		return statsDao.getPatientVisitTrend();
	}

	@Transactional
	public byte[] getPatientVisitTrendChart() {
		log.info("Generating stats chart..");
		
		try {
			List<VisitStats> stats = statsDao.getPatientVisitTrend();

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			

			for (VisitStats s : stats) {
				dataset.addValue(s.getCount(), "Patients", s.getDate());
			}

			JFreeChart barChart = ChartFactory.createBarChart(
					"Patient Visit Trend (60 days)", "Date", "Visit Count",
					dataset,PlotOrientation.VERTICAL,           
			         true, false, false);
			
			StackedBarRenderer renderer = new StackedBarRenderer(false);
			renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setBaseItemLabelsVisible(true);
			barChart.getCategoryPlot().setRenderer(renderer);
			
			// make x axis labels tilted
	        CategoryPlot catPlot = barChart.getCategoryPlot();
	        CategoryAxis domainAxis = catPlot.getDomainAxis();
	        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
	        
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			ChartUtilities.writeChartAsPNG(baos, barChart, 600, 300);
			return baos.toByteArray();
			
		} catch (IOException e) {
			log.error("IOException while generating patient visit stats chart", e);
		} catch (Exception e) {
			log.error("Exception while generating patient visit stats chart", e);
		} finally {
			//
		}
		return null;
	}

}
