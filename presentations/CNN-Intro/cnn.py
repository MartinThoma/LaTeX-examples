import data

from keras.layers import Dense, Flatten, Conv2D, MaxPooling2D
from keras.models import Sequential, load_model

model = Sequential()
model.add(Conv2D(16, (3, 3)))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(Conv2D(16, (3, 3)))
model.add(Flatten())
model.add(Dense(128, activation='relu'))
model.add(Dense(data.n_classes, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam')
model.fit(data.x_train, data.y_train)

model.save('model.h5')
model = load_model('model.h5')
y_predicted = model.predict(data.x_test)
