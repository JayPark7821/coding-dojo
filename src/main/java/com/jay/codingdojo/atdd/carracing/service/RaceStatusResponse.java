package com.jay.codingdojo.atdd.carracing.service;

import java.util.List;
import java.util.Map;

public record RaceStatusResponse(Long raceId, List<Map<String, Integer>> history, List<String> winner) {
}
