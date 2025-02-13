package com.example.democarousel.domain

class GetDataUseCase(val soundRepository: SoundRepository) {
    operator fun invoke() = soundRepository.getSounds()
}